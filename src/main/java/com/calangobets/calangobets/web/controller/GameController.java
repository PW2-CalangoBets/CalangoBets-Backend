package com.calangobets.calangobets.web.controller;

import com.calangobets.calangobets.entity.GameHistory;
import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.service.GameService;
import com.calangobets.calangobets.service.HistoryService;
import com.calangobets.calangobets.service.UserService;
import com.calangobets.calangobets.web.dto.GameDto;
import com.calangobets.calangobets.web.dto.PageableDto;
import com.calangobets.calangobets.web.dto.mapper.GameMapper;
import com.calangobets.calangobets.web.dto.mapper.PageableMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Game Application", description = "Crud methods for games, creates a game history and updates user cdb")
@RequestMapping("api/game")
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameHistory> createGameHistory (@AuthenticationPrincipal User user, @Valid @RequestBody GameDto gameDto) {
        GameHistory game = gameService.processGame(user, GameMapper.toGameHistory(gameDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllGameHistory (@AuthenticationPrincipal User user, Pageable pageable) {
        Page<GameHistory> page = gameService.getAll(pageable, user.getId());
        return ResponseEntity.ok(PageableMapper.toDto(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameHistory> getById (@AuthenticationPrincipal User user, @PathVariable String id) {
        GameHistory gameHistory = gameService.findById(user.getId(), id);
        return ResponseEntity.ok(gameHistory);
    }

}
