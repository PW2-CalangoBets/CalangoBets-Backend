package com.calangobets.calangobets.service;

import com.calangobets.calangobets.entity.GameHistory;
import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.exception.AuthorizationErrorException;
import com.calangobets.calangobets.exception.EntityNotFoundException;
import com.calangobets.calangobets.exception.NotEnoughCdbException;
import com.calangobets.calangobets.repository.GameRepository;
import com.calangobets.calangobets.web.dto.GameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final UserService userService;

    public GameHistory processGame (User user, GameHistory gameHistory) {
        if (user.getCdb().equals(BigDecimal.ZERO)) throw new NotEnoughCdbException("Not enough cash to play buddy!");
        gameHistory.setPlayerId(user.getId());
        userService.handleGameResult(user, gameHistory.getCdb(), gameHistory.getResult());
        return gameRepository.save(gameHistory);
    }

    public Page<GameHistory> getAll (Pageable pageable, String userId) {
        return gameRepository.findAllByPlayerId(userId, pageable);
    }

    public GameHistory findById(String userId, String historyId) {
        GameHistory gameHistory = gameRepository.findById(historyId).orElseThrow(
                () -> new EntityNotFoundException("entity not found!"));
        if(!Objects.equals(userId, gameHistory.getPlayerId()))
            throw new AuthorizationErrorException("You don't have access to this method");
        return gameHistory;
    }
}
