package com.halfaro.challenge_ibk.application.service;

import com.halfaro.challenge_ibk.application.client.ExchangeRateClient;
import com.halfaro.challenge_ibk.application.dto.ExchangeRateResponse;
import com.halfaro.challenge_ibk.infrastructure.entity.ExchangeTransaction;
import com.halfaro.challenge_ibk.infrastructure.repository.ExchangeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateClient exchangeRateClient;

    @Autowired
    private ExchangeTransactionRepository exchangeTransactionRepository;


    public double getExchangeRate(String currencyFrom, String currencyTo) {
        ExchangeRateResponse response = exchangeRateClient.getExchangeRates(currencyFrom);
        Double rate = response.getRates().get(currencyTo);

        if (rate == null) {
            throw new IllegalArgumentException("Tipo de cambio no encontrado para la moneda destino: " + currencyTo);
        }

        return rate;
    }

    public void saveTransaction(double amount, double amountWithExchangeRate, String currencyFrom, String currencyTo, double rate) {
        ExchangeTransaction transaction = new ExchangeTransaction();
        transaction.setExchangeRate(rate);
        transaction.setAmount(amount);
        transaction.setAmountWithRate(amountWithExchangeRate);
        transaction.setCurrencyTo(currencyTo);
        transaction.setCurrencyFrom(currencyFrom);
        exchangeTransactionRepository.save(transaction);
    }

    public List<ExchangeTransaction> findAll(){
        return exchangeTransactionRepository.findAll();
    }
}