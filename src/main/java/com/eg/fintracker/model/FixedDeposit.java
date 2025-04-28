package com.eg.fintracker.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FixedDeposit {
    private String id;
    private String bankName;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;  // Annual interest rate as percentage
    private LocalDate startDate;
    private LocalDate maturityDate;
    private int tenureInMonths;
    private BigDecimal maturityAmount;
}
