package com.calangobets.calangobets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Document
public class History implements Serializable {
    @Id
    private String id;
    private Operation operation;
    private LocalDateTime date;
    private BigDecimal value;
    private BigDecimal accountCdb;
    private String userId;
}
