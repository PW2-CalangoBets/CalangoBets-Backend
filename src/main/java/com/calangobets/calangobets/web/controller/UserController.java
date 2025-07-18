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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id) {
        User user = service.getById(id);
        return ResponseEntity.ok().body(UserMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserCreateDto createDto) {
        User user = service.create(UserMapper.toUser(createDto));
        return ResponseEntity.status(201).body(UserMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UserUpdateDto updateDto, @PathVariable String id) {
        service.update(id, updateDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
