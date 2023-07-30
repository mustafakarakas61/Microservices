package com.mustafa.customer.service;

import com.mustafa.customer.config.MapperConfig;
import com.mustafa.customer.entity.CustomerEntity;
import com.mustafa.customer.dto.CustomerDTO;
import com.mustafa.customer.repository.CustomerRepository;
import com.mustafa.customer.model.FraudCheckResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity= MapperConfig.getModelMapper().map(customerDTO, CustomerEntity.class);


        customerRepository.save(customerEntity); // Genellikle, save metodu daha yaygın olarak tercih edilir çünkü performans açısından daha iyidir. saveAndFlush metodunun kullanılması özellikle, bir nesnenin kaydedilmesi veya güncellenmesi sonrasında hemen veritabanı üzerinde başka işlemler yapılması gereken özel durumlarda tercih edilebilir.
        FraudCheckResponseModel fraudCheckResponseModel = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",//"http://localhost:8081/api/v1/fraud-check/{customerId}", "http://FRAUD/api/v1/fraud-check/{customerId}"
                FraudCheckResponseModel.class,
                customerEntity.getId()
        );
        assert fraudCheckResponseModel != null;
        if (fraudCheckResponseModel.getFraudster()) {
            throw new IllegalStateException("fraudster");
        }


    }
}
