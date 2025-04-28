package com.eg.fintracker.web;

import com.eg.fintracker.model.FixedDeposit;
import com.eg.fintracker.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fixed-deposits")
@CrossOrigin(origins = "*") // For development only
public class FixedDepositController {

    private final FixedDepositService fixedDepositService;

    @Autowired
    public FixedDepositController(FixedDepositService fixedDepositService) {
        this.fixedDepositService = fixedDepositService;
    }

    @GetMapping
    public List<FixedDeposit> getAllFixedDeposits() {
        return fixedDepositService.getAllFixedDeposits();
    }

    @GetMapping("/growth-data")
    public List<FixedDeposit> getGrowthData() {
        return fixedDepositService.getGrowthData();
    }
}
