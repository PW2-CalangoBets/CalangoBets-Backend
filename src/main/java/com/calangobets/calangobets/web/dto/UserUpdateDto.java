package com.calangobets.calangobets.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserUpdateDto {
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal cdb;
    @NotBlank @Size(min = 6)
    private String password;
}
