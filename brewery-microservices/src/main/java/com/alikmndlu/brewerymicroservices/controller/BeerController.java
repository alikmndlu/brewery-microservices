package com.alikmndlu.brewerymicroservices.controller;

import com.alikmndlu.brewerymicroservices.dto.BeerDto;
import com.alikmndlu.brewerymicroservices.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beers")
@RequiredArgsConstructor
@Slf4j
public class BeerController {

    private final BeerService beerService;

    // get beer by id
    @GetMapping("/{beer-id}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beer-id") UUID id) {
        log.info("Inside getBeer method of BeerController");
        return ResponseEntity.ok(beerService.getBeerById(id));
    }

    // save new beer
    @PostMapping("/")
    public ResponseEntity<?> handleCreate(@RequestBody BeerDto beerDto) {
        log.info("Inside handleCreate method of BeerController");
        BeerDto savedBeer = beerService.saveNewBeer(beerDto);
        return ResponseEntity.created(
                URI.create("/api/v1/beers/" + savedBeer.getId().toString())
        ).build();
    }

    // update existing beer
    @PutMapping("/{beer-id}")
    public ResponseEntity<?> handleUpdate(@PathVariable("beer-id") UUID id, @RequestBody BeerDto beerDto){
        log.info("Inside handleUpdate method of BeerController");
        beerService.updateBeer(id, beerDto);
        return ResponseEntity.noContent().build();
    }

    // delete beer
    @DeleteMapping("/{beer-id}")
    public ResponseEntity<?> handleDelete(@PathVariable("beer-id") UUID id){
        log.info("Inside handleDelete method of BeerController");
        beerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
