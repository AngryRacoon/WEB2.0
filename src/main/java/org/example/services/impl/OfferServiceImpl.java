package org.example.services.impl;


import org.example.dtos.OfferDto;
import org.example.models.Offer;
import org.example.repositories.OfferRepository;
import org.example.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class OfferServiceImpl implements OfferService<UUID> {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OfferDto register(OfferDto offer) {
        if(offer.getId()!=null){
            offer.setModified(new Date());
        }
        Offer o = modelMapper.map(offer, Offer.class);
        return modelMapper.map(offerRepository.save(o),OfferDto.class);
    }

    @Override
    public void expel(OfferDto brand) {
        offerRepository.deleteById((brand.getId()));
    }

    @Override
    public void expel(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Optional<OfferDto> findOffer(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id),OfferDto.class));
    }

    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll().stream().map((o) ->
                modelMapper.map(o, OfferDto.class)).collect(Collectors.toList());
    }

}
