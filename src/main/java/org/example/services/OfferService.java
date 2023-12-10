package org.example.services;

import org.example.dtos.AddOfferDto;
import org.example.dtos.BrandDto;
import org.example.dtos.LightOfferDto;
import org.example.dtos.OfferDto;

import java.util.List;
import java.util.Optional;

public interface OfferService<UUID>{
    void register(AddOfferDto offer);
    void expel (OfferDto offer);
    void expel(UUID id);
    Optional<OfferDto> findOffer(UUID id);
    List<LightOfferDto> getAll();
}
