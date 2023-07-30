package com.mustafa.customer.controller;

import com.mustafa.customer.dto.CustomerDTO;
import com.mustafa.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController{

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping(value = "/")
    public void registerCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.registerCustomer(customerDTO);
        LOGGER.info("New customer registered " + customerDTO);
    }
}
