package com.eg.fintracker.repository;

import com.eg.fintracker.model.FixedDeposit;

import java.util.List;

public interface FixedDepositRepository {

    List<FixedDeposit> findAll();

    FixedDeposit save(FixedDeposit fixedDeposit);

    void deleteById(String id);
    // Other methods...
}