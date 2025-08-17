package com.calangobets.calangobets.web.dto.mapper;

import com.calangobets.calangobets.entity.GameHistory;
import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.web.dto.GameDto;
import com.calangobets.calangobets.web.dto.HistoryCreateDto;
import org.modelmapper.ModelMapper;

public class GameMapper {
    public static GameHistory toGameHistory (GameDto gameDto) {
        return new ModelMapper().map(gameDto, GameHistory.class);
    }
}
