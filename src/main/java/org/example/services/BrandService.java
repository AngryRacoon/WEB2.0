package org.example.services;

import org.example.dtos.AddBrandDto;
import org.example.dtos.BrandDto;
import org.example.dtos.LightBrandDto;

import java.util.List;
import java.util.Optional;

public interface BrandService<UUID> {
    AddBrandDto register(AddBrandDto brand);
    LightBrandDto edit(LightBrandDto brand);
    void expel (BrandDto user);
    void expel(UUID id);
    Optional<BrandDto> findBrand(UUID id);
    Optional<LightBrandDto> findLightBrand(UUID id);
    List<LightBrandDto> getAll();
}
