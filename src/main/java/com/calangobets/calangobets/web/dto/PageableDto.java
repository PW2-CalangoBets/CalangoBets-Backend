package com.calangobets.calangobets.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageableDto {
    private List<?> content = new ArrayList<>();
    private boolean first;
    private boolean last;
    @JsonProperty("page")
    private int number;
    private int size;
    @JsonProperty("pageElementsAmount")
    private int numberOfElements;
    private int totalPages;
    private int totalElements;
}