package com.calangobets.calangobets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class GameHistory {
    @Id
    private String id;
    private String playerId;
    private String gameName;
    private BigDecimal cdb;
    private Result result;
}
