package com.eg.fintracker.service;

import com.eg.fintracker.model.FixedDeposit;
import com.eg.fintracker.repository.FixedDepositRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class FixedDepositService {

    @Value("${app.use-mongodb:false}")
    private boolean useMongoDb;

    private final FixedDepositRepository repository;

    @Autowired
    public FixedDepositService(FixedDepositRepository repository) {
        this.repository = repository;
    }

    public List<FixedDeposit> getAllFixedDeposits() {
        if (useMongoDb) {
            return repository.findAll();
        } else {
            return getFixedDepositsFromJson();
        }
    }

    private List<FixedDeposit> getFixedDepositsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/fixed-deposits.json");
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException e) {
            log.error("Error reading fixed deposits JSON file", e);
            return Collections.emptyList();
        }
    }

    // Method to calculate growth data points for charts
    public List<FixedDeposit> getGrowthData() {
        // This will be implemented to calculate month-by-month growth for the charts
        // For now, we'll just return all deposits
        return getAllFixedDeposits();
    }
}
