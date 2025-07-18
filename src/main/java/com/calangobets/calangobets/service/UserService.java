package com.calangobets.calangobets.service;

import com.calangobets.calangobets.entity.User;
import com.calangobets.calangobets.exception.EntityNotFoundException;
import com.calangobets.calangobets.repository.UserRepository;
import com.calangobets.calangobets.web.dto.UserUpdateDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Transactional(readOnly = true)
    public User getById(String id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
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

    private void update(User user, UserUpdateDto updateDto) {
        if(updateDto.getCdb() != null) user.setCdb(updateDto.getCdb());
        if(updateDto.getName() != null) user.setName(updateDto.getName());
        if(updateDto.getPassword() != null) user.setPassword(updateDto.getPassword());
    }
}
