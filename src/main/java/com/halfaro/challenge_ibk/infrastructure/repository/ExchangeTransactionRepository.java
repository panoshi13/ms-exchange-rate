package com.halfaro.challenge_ibk.infrastructure.repository;

import com.halfaro.challenge_ibk.infrastructure.entity.ExchangeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeTransactionRepository extends JpaRepository<ExchangeTransaction, Long> {

}