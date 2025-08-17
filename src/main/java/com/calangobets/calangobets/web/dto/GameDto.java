package com.calangobets.calangobets.web.dto;

import com.calangobets.calangobets.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GameDto {
    private String gameName;
    private BigDecimal cdb;
    private Result result;
}
