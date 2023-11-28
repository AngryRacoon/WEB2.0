package org.example.controllers;

import org.example.dtos.BrandDto;
import org.example.services.BrandService;
import org.example.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private BrandService<UUID> brandService;

    @Autowired
    public void setBrandService(BrandService<UUID> brandService) {
        this.brandService = brandService;
    }


    @PostMapping("/new")
    public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto) {
        BrandDto createdBrand = brandService.register(brandDto);
        return ResponseEntity.ok(createdBrand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable UUID id) {
        brandService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> getBrand(@PathVariable UUID id) {
        return brandService.findBrand(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        List<BrandDto> brands = brandService.getAll();
        return ResponseEntity.ok(brands);
    }
}
