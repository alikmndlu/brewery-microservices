package com.alikmndlu.brewerymicroservices.controller;

import com.alikmndlu.brewerymicroservices.dto.CustomerDto;
import com.alikmndlu.brewerymicroservices.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customer-id") UUID id){
        log.info("Inside getCustomer method of CustomerController");
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
