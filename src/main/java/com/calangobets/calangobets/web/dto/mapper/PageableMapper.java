package com.calangobets.calangobets.web.dto.mapper;

import com.calangobets.calangobets.web.dto.PageableDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class PageableMapper {
    public static PageableDto toDto (Page<?> page) {
        return new ModelMapper().map(page, PageableDto.class);
    }
}
