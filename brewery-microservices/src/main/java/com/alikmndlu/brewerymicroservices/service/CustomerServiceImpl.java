package com.alikmndlu.brewerymicroservices.service;

import com.alikmndlu.brewerymicroservices.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID id) {
        log.info("Inside getCustomerById method of CustomerServiceImpl");
        return CustomerDto.builder()
                .id(id)
                .name("Ali Kmndlu")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        log.info("Inside saveNewCustomer method of CustomerServiceImpl");
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }
}
