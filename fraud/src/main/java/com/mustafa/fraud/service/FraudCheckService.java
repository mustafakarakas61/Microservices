package com.mustafa.fraud.service;

import com.mustafa.fraud.repository.FraudCheckHistoryRepository;
import com.mustafa.fraud.entity.FraudCheckHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
/*
    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }
*///@AllArgsConstructor kullandık

    public boolean isFraudulentCustomer(Integer customerId){

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
