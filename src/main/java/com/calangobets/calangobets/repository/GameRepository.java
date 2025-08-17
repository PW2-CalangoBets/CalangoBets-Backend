package com.calangobets.calangobets.repository;

import com.calangobets.calangobets.entity.GameHistory;
import com.calangobets.calangobets.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<GameHistory, String> {
    Page<GameHistory> findAllByPlayerId (String playerId, Pageable pageable);
}
