package org.example.services.impl;

import org.example.dtos.BrandDto;
import org.example.models.Brand;
import org.example.repositories.BrandRepository;
import org.example.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService<UUID> {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BrandDto register(BrandDto brand) {
        if(brand.getId()!=null){
            brand.setModified(new Date());
        }
        Brand b = modelMapper.map(brand, Brand.class);
        return modelMapper.map(brandRepository.save(b),BrandDto.class);
    }

    @Override
    public void expel(BrandDto brand) {
        brandRepository.deleteById((brand.getId()));
    }

    @Override
    public void expel(UUID id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Optional<BrandDto> findBrand(UUID id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id),BrandDto.class));
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((b) ->
                modelMapper.map(b, BrandDto.class)).collect(Collectors.toList());
    }
}