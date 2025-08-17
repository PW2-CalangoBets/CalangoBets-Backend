package com.calangobets.calangobets.service;

import com.calangobets.calangobets.entity.Operation;
import com.calangobets.calangobets.entity.Result;
import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.exception.EntityNotFoundException;
import com.calangobets.calangobets.exception.NotEnoughCdbException;
import com.calangobets.calangobets.repository.UserRepository;
import com.calangobets.calangobets.web.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User getById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("eita"));
    }

    public User create(User user) {
        user.setCdb(BigDecimal.ZERO);
        return repository.save(user);
    }

    public void update(String id, UserUpdateDto updateDto) {
        User user = getById(id);
        update(user, updateDto);
        repository.save(user);
    }

    public void updateCdb (User user, BigDecimal amount, Operation operation) {
        if(operation == Operation.DEPOSIT) {
            user.setCdb(user.getCdb().add(amount));
            user.setTotalDeposit(user.getTotalDeposit().add(amount));
        } else {
            if(user.getCdb().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
                user.setCdb(user.getCdb().subtract(amount));
            }
            else throw new NotEnoughCdbException("Not enough cash buddy!");
        }
        repository.save(user);
    }

    public void handleGameResult(User user, BigDecimal amount, Result result) {
        if(result == Result.WIN) {
            user.setCdb(user.getCdb().add(amount));
            user.setWins(user.getWins().add(amount));
        } else {
            if(user.getCdb().subtract(amount).compareTo(BigDecimal.ZERO) >= 0) {
                user.setCdb(user.getCdb().subtract(amount));
                user.setLooses(user.getLooses().add(amount));
            }
            else throw new NotEnoughCdbException("How are you gonna play without money?");
        }
        repository.save(user);
    }

    private void update(User user, UserUpdateDto updateDto) {
        if(updateDto.getCdb() != null) user.setCdb(updateDto.getCdb());
        if(updateDto.getName() != null) user.setName(updateDto.getName());
        if(updateDto.getPassword() != null) user.setPassword(updateDto.getPassword());
    }
}
