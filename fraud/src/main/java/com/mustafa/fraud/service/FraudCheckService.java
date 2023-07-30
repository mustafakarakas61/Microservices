package com.mustafa.fraud.service;

import com.mustafa.fraud.repository.FraudCheckHistoryRepository;
import com.mustafa.fraud.entity.FraudCheckHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }


    public boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory fraudCheckHistory = new FraudCheckHistory();

        fraudCheckHistory.setCustomerId(customerId);
        fraudCheckHistory.setFraudster(false);
        fraudCheckHistory.setCreateAt(LocalDateTime.now());

        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
