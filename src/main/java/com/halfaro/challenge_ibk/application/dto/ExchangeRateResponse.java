package com.halfaro.challenge_ibk.application.dto;

import lombok.Data;

import java.util.Map;
@Data
public class ExchangeRateResponse {
    private String base_code;
    private Map<String, Double> rates;
}