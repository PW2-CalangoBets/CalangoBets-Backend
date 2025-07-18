package com.calangobets.calangobets.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserCreateDto {
    @NotBlank
    private String name;
    @NotBlank @Email(message = "Invalid email format", regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    @NotBlank @Size(min = 6)
    private String password;
}
