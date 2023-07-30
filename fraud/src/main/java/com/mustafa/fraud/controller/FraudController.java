package com.mustafa.fraud.controller;

import com.mustafa.fraud.model.FraudCheckResponseModel;
import com.mustafa.fraud.service.FraudCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final Logger LOGGER = LoggerFactory.getLogger(FraudController.class);

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponseModel isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        FraudCheckResponseModel checkResponseModel = new FraudCheckResponseModel();
        checkResponseModel.setFraudster(isFraudulentCustomer);
        LOGGER.info("Fraud check request for customer {}", customerId);

        return checkResponseModel;
    }
}
