package com.calangobets.calangobets.web.controller;

import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.repository.UserRepository;
import com.calangobets.calangobets.security.TokenService;
import com.calangobets.calangobets.web.dto.mapper.UserMapper;
import com.calangobets.calangobets.web.dto.user.AuthDto;
import com.calangobets.calangobets.web.dto.user.LoginResponseDto;
import com.calangobets.calangobets.web.dto.user.RegisterDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Auth methods")
@RequestMapping("api/auth")
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login (@RequestBody @Valid AuthDto authDto) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register (@RequestBody @Valid RegisterDto registerDto) {
        if (userRepository.findByEmail(registerDto.getEmail()) != null ) return ResponseEntity.badRequest().build();

        String encryptPassword =  new BCryptPasswordEncoder().encode(registerDto.getPassword());
        registerDto.setPassword(encryptPassword);
        User newUser = UserMapper.toUser(registerDto);
        newUser.setCdb(BigDecimal.ZERO);
        newUser.setWins(BigDecimal.ZERO);
        newUser.setLooses(BigDecimal.ZERO);
        newUser.setTotalDeposit(BigDecimal.ZERO);
        userRepository.save(newUser);

        return ResponseEntity.status(201).build();
    }
}
