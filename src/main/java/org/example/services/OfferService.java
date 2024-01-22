package org.example.services;

import jakarta.validation.Valid;
import org.example.dtos.*;

import java.util.List;
import java.util.Optional;

public interface OfferService<UUID>{
    void register(AddOfferDto offer);
    void expel (OfferDto offer);
    void expel(UUID id);
    Optional<OfferDto> findOffer(UUID id);
    List<LightOfferDto> getAll();
    void edit(@Valid EditOfferDto userDto);

}
