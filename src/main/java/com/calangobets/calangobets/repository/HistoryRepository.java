package com.calangobets.calangobets.repository;

import com.calangobets.calangobets.entity.History;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {
}
