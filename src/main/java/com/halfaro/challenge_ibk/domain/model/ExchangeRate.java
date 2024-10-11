package com.halfaro.challenge_ibk.domain.model;

import lombok.Data;

@Data
public class ExchangeRate {
    private String currencyFrom;
    private String currencyTo;
    private double rate;
}
