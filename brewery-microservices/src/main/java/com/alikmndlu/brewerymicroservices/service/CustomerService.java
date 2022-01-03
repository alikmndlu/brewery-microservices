package com.alikmndlu.brewerymicroservices.service;

import com.alikmndlu.brewerymicroservices.dto.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
}
