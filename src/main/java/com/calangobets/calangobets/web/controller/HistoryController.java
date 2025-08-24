package com.calangobets.calangobets.web.controller;

import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.service.HistoryService;
import com.calangobets.calangobets.web.dto.HistoryCreateDto;
import com.calangobets.calangobets.web.dto.PageableDto;
import com.calangobets.calangobets.web.dto.mapper.HistoryMapper;
import com.calangobets.calangobets.web.dto.mapper.PageableMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Transaction History", description = "Manages the transaction methods, updating user cdb's after transactions")
@RequestMapping("api/transaction")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping
    public ResponseEntity<History> createHistory (@AuthenticationPrincipal User user, @Valid @RequestBody HistoryCreateDto createDto) {
        History history = historyService.saveHistory(user, HistoryMapper.toHistory(createDto));
        return ResponseEntity.status(201).body(history);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllHistory (@AuthenticationPrincipal User user, Pageable pageable) {
        Page<History> page = historyService.getAll(pageable, user.getId());
        return ResponseEntity.ok(PageableMapper.toDto(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getById (@AuthenticationPrincipal User user, @PathVariable String id) {
        History history = historyService.findById(user.getId(), id);
        return ResponseEntity.ok(history);
    }
}
