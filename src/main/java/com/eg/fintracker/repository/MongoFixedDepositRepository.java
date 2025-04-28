package com.eg.fintracker.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "app.use-mongodb", havingValue = "true")
public interface MongoFixedDepositRepository extends MongoRepository, FixedDepositRepository {
    // Additional query methods can be defined here if needed
}
