package com.alikmndlu.brewerymicroservices.service;

import com.alikmndlu.brewerymicroservices.dto.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID id);
}
