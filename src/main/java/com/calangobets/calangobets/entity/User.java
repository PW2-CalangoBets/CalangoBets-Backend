package com.calangobets.calangobets.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Document(collection = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private BigDecimal cdb;
    private String password;
}
