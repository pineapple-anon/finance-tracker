package com.eg.fintracker.repository;

import com.eg.fintracker.model.FixedDeposit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
@ConditionalOnProperty(name = "app.use-mongodb", havingValue = "false", matchIfMissing = true)
public class JsonFixedDepositRepository implements FixedDepositRepository {

    private final ObjectMapper objectMapper;

    public JsonFixedDepositRepository() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public List<FixedDeposit> findAll() {
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/fixed-deposits.json");
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException e) {
            log.error("Error reading fixed deposits JSON file", e);
            return Collections.emptyList();
        }
    }

    @Override
    public FixedDeposit save(FixedDeposit fixedDeposit) {
        // Implementation would depend on how you want to handle writes
        // For example, you could read the JSON file, add/update the entity, and write it back
        if (fixedDeposit.getId() == null) {
            fixedDeposit.setId(UUID.randomUUID().toString());
        }
        return fixedDeposit;
    }

    @Override
    public void deleteById(String id) {
        // Implementation would depend on how you want to handle deletes
        // For example, you could read the JSON file, remove the entity, and write it back
    }
}
