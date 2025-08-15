package com.calangobets.calangobets.web.dto.mapper;

import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.web.dto.HistoryCreateDto;
import org.modelmapper.ModelMapper;

public class HistoryMapper {
    public static History toHistory (HistoryCreateDto createDto) {
        return new ModelMapper().map(createDto, History.class);
    }
}
