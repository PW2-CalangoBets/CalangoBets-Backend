package com.calangobets.calangobets.service;

import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.exception.EntityNotFoundException;
import com.calangobets.calangobets.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private HistoryRepository historyRepository;

    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    public Page<History> getAll (Pageable pageable) {
        return historyRepository.findAll(pageable);
    }

    public History findById(String id) {
        return historyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("entity not found!"));
    }


}
