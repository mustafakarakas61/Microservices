package com.mustafa.fraud.repository;

import com.mustafa.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {

}
