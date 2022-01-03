package com.alikmndlu.brewerymicroservices.service.impl;

import com.alikmndlu.brewerymicroservices.dto.BeerDto;
import com.alikmndlu.brewerymicroservices.service.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID id) {
        log.info("Inside getBeerById method of BeerServiceImpl");
        return BeerDto.builder()
                .id(id)
                .name("Corona")
                .style("Ghooti")
                .upc(13L)
                .build();
    }
}
