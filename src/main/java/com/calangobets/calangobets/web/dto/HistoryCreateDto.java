package com.calangobets.calangobets.web.dto;

import com.calangobets.calangobets.entity.Operation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class HistoryCreateDto {
    @NotBlank
    private Operation operation;
    @NumberFormat @NotNull
    private BigDecimal value;
}
