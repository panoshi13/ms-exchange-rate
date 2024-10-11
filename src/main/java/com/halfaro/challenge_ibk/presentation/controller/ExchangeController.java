package com.halfaro.challenge_ibk.presentation.controller;

import com.halfaro.challenge_ibk.application.dto.ExchangeRequest;
import com.halfaro.challenge_ibk.application.dto.ExchangeResponse;
import com.halfaro.challenge_ibk.application.service.ExchangeRateService;
import com.halfaro.challenge_ibk.infrastructure.entity.ExchangeTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping("/apply")
    public ExchangeResponse applyExchangeRate(@RequestBody ExchangeRequest request) {
        double rate = exchangeRateService.getExchangeRate(request.getCurrencyFrom(), request.getCurrencyTo());
        double amountWithExchangeRate = request.getAmount() * rate;

        // Guardar la transacción en la base de datos
        exchangeRateService.saveTransaction(
                request.getAmount(),
                amountWithExchangeRate,
                request.getCurrencyFrom(),
                request.getCurrencyTo(),
                rate
        );

        return new ExchangeResponse(
                request.getAmount(),
                amountWithExchangeRate,
                request.getCurrencyFrom(),
                request.getCurrencyTo(),
                rate
        );
    }

    @GetMapping("/transactions")
    public List<ExchangeTransaction> getAllTransactions() {
        return exchangeRateService.findAll();
    }
}
