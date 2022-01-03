package com.alikmndlu.brewerymicroservices.controller;

import com.alikmndlu.brewerymicroservices.dto.CustomerDto;
import com.alikmndlu.brewerymicroservices.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    // get customer by id
    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customer-id") UUID id) {
        log.info("Inside getCustomer method of CustomerController");
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    // save new customer
    @PostMapping("/")
    public ResponseEntity<?> saveNewCustomer(@RequestBody CustomerDto customerDto) {
        log.info("Inside saveNewCustomer method of CustomerController");
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);
        return ResponseEntity.created(
                URI.create("/api/v1/customers/" + savedCustomer.getId().toString())
        ).build();
    }
}
