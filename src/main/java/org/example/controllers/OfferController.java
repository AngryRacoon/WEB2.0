package org.example.controllers;

import org.example.dtos.OfferDto;
import org.example.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OfferController {


    private OfferService<UUID> offerService;

    @Autowired
    public void setOfferService(OfferService<UUID> offerService) {
        this.offerService = offerService;
    }
    @PostMapping
    public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto) {
        OfferDto createdOffer = offerService.register(offerDto);
        return ResponseEntity.ok(createdOffer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        offerService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> getOffer(@PathVariable UUID id) {
        return offerService.findOffer(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        List<OfferDto> offers = offerService.getAll();
        return ResponseEntity.ok(offers);
    }
}
