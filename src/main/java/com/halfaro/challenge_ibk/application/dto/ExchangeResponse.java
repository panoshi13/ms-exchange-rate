package com.halfaro.challenge_ibk.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeResponse {
    private double amount;
    private double amountExchangeRate;
    private String currencyFrom;
    private String currencyTo;
    private double exchangeRate;
}
