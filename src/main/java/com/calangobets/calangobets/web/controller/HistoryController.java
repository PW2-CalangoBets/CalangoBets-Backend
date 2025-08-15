package com.calangobets.calangobets.web.controller;

import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/history")
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<Page<History>> getAllHistory (@AuthenticationPrincipal User user, Pageable pageable) {
        Page<History> page = historyService.getAll(pageable, user.getId());
        return ResponseEntity.ok(page);
    }
}
