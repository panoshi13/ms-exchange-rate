package com.halfaro.challenge_ibk.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeRequest {
    private double amount;
    private String currencyFrom;
    private String currencyTo;
}
