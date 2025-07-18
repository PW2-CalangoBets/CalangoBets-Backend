package com.calangobets.calangobets.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class UserResponseDto {
    private String id;
    private String name;
    private String email;
    private BigDecimal cdb;
}
