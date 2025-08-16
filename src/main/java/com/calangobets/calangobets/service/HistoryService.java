package com.calangobets.calangobets.service;

import com.calangobets.calangobets.entity.History;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.exception.AuthorizationErrorException;
import com.calangobets.calangobets.exception.EntityNotFoundException;
import com.calangobets.calangobets.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final UserService userService;

    public History saveHistory(User user, History history) {
        history.setUserId(user.getId());
        history.setAccountCdb(user.getCdb());
        userService.updateCdb(user, history.getValue(), history.getOperation());
        return historyRepository.save(history);
    }

    public Page<History> getAll (Pageable pageable, String userId) {
        return historyRepository.findAllByUserId(userId, pageable);
    }

    public History findById(String userId, String historyId) {
        History history = historyRepository.findById(historyId).orElseThrow(
                () -> new EntityNotFoundException("entity not found!"));
        if(!Objects.equals(userId, history.getUserId()))
            throw new AuthorizationErrorException("You don't have access to this method");
        return history;
    }


}
