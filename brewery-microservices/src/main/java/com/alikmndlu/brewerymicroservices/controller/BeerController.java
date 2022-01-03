package com.alikmndlu.brewerymicroservices.controller;

import com.alikmndlu.brewerymicroservices.dto.BeerDto;
import com.alikmndlu.brewerymicroservices.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beers")
@RequiredArgsConstructor
@Slf4j
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beer-id}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beer-id") UUID id){
        log.info("Inside getBeer method of BeerController");
        return ResponseEntity.ok(beerService.getBeerById(id));
    }

}
