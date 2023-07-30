package com.mustafa.fraud.model;

import org.springframework.stereotype.Component;

@Component
public class FraudCheckResponseModel {

    private boolean isFraudster;

    public boolean isFraudster() {
        return isFraudster;
    }

    public void setFraudster(boolean fraudster) {
        isFraudster = fraudster;
    }
}
