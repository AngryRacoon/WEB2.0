package org.example.services.impl;

import org.example.dtos.AddBrandDto;
import org.example.dtos.BrandDto;
import org.example.dtos.LightBrandDto;
import org.example.models.Brand;
import org.example.repositories.BrandRepository;
import org.example.services.BrandService;
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
public class BrandServiceImpl implements BrandService<UUID> {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public AddBrandDto register(AddBrandDto brand) {
        Brand b = modelMapper.map(brand, Brand.class);
        b.setCreated(new Date());

        return modelMapper.map(brandRepository.save(b),AddBrandDto.class);
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public LightBrandDto edit(LightBrandDto brand) {
        Brand b = brandRepository.findById(brand.getId()).orElseThrow(() -> new RuntimeException("Brand not found"));
        b.setModified(new Date());
        return modelMapper.map(brandRepository.save(b),LightBrandDto.class);
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void expel(BrandDto brand) {
        brandRepository.deleteById((brand.getId()));
    }

    @Override
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void expel(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    @Cacheable("brands")
    public Optional<BrandDto> findBrand(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id),BrandDto.class));
    }

    @Override
    @Cacheable("brands")
    public Optional<LightBrandDto> findLightBrand(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id),LightBrandDto.class));
    }

    @Override
    @Cacheable("brands")
    public List<LightBrandDto> getAll() {
        return brandRepository.findAll().stream().map((b) ->
                modelMapper.map(b, LightBrandDto.class)).collect(Collectors.toList());
    }
}
