package org.example.services.impl;


import org.example.dtos.*;
import org.example.dtos.LightOfferDto;
import org.example.models.Offer;
import org.example.repositories.ModelRepository;
import org.example.repositories.OfferRepository;
import org.example.repositories.UserRepository;
import org.example.services.OfferService;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class OfferServiceImpl implements OfferService<UUID> {
    private OfferRepository offerRepository;

    private ModelRepository modelRepository;

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private AuthService authService;
    @Autowired
    public void AuthController(AuthService authService) {
        this.authService = authService;
    }
    @Autowired
    public void setOfferRepository(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void register(AddOfferDto offer) {

        Offer o = modelMapper.map(offer, Offer.class);
        o.setModel(modelRepository.findById(offer.getModel()).orElse(null));
        o.setUser(userRepository.findByUsername(offer.getUser()).orElse(null));
        o.setCreated(new Date());
        offerRepository.saveAndFlush(o);
    }

    @Override
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void expel(OfferDto brand) {
        offerRepository.deleteById((brand.getId()));
    }

    @Override
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void expel(UUID id) {
        offerRepository.deleteById(id);
    }

    @Override
    @Cacheable("offers")
    public Optional<OfferDto> findOffer(UUID id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id),OfferDto.class));
    }

    @Override
    @Cacheable("offers")
    public List<LightOfferDto> getAll() {
        return offerRepository.findAll().stream().map((o) ->
                modelMapper.map(o, LightOfferDto.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("offers")
    public void edit(EditOfferDto userDto) {
        Offer o = modelMapper.map(userDto, Offer.class);
        o.setModel(modelRepository.findById(userDto.getModel()).orElse(null));
        o.setUser(userRepository.findById(userDto.getUser()).orElse(null));
        offerRepository.saveAndFlush(o);
    }

}
