package org.example.services;

import org.example.dtos.BrandDto;
import org.example.dtos.OfferDto;

import java.util.List;
import java.util.Optional;

public interface OfferService<UUID>{
    OfferDto register(OfferDto offer);
    void expel (OfferDto offer);
    void expel(UUID id);
    Optional<OfferDto> findOffer(UUID id);
    List<OfferDto> getAll();
}
