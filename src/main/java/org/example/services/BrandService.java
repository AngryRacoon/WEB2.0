package org.example.services;

import org.example.dtos.BrandDto;
import java.util.List;
import java.util.Optional;

public interface BrandService<UUID> {
    BrandDto register(BrandDto user);
    void expel (BrandDto user);
    void expel(UUID id);
    Optional<BrandDto> findBrand(UUID id);
    List<BrandDto> getAll();
}
