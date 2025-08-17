package com.calangobets.calangobets.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UserResponseDto {
    private String id;
    private String name;
    private String email;
    private BigDecimal cdb;
    private BigDecimal totalDeposit;
    private BigDecimal wins;
    private BigDecimal looses;
}
