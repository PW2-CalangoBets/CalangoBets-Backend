package com.calangobets.calangobets.web.controller;

import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.service.UserService;
import com.calangobets.calangobets.web.dto.UserCreateDto;
import com.calangobets.calangobets.web.dto.UserResponseDto;
import com.calangobets.calangobets.web.dto.UserUpdateDto;
import com.calangobets.calangobets.web.dto.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService service;

    @GetMapping()
    public ResponseEntity<UserResponseDto> getById(@AuthenticationPrincipal User user) {
        User info = service.getById(user.getId());
        return ResponseEntity.ok().body(UserMapper.toDto(info));
    }

    @PatchMapping()
    public ResponseEntity<Void> update(@Valid @RequestBody UserUpdateDto updateDto, @AuthenticationPrincipal User user) {
        service.update(user.getId(), updateDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
