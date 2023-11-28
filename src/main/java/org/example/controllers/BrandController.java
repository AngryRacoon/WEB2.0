package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.AddBrandDto;
import org.example.dtos.BrandDto;
import org.example.services.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private BrandService<UUID> brandService;

    @Autowired
    public void setBrandService(BrandService<UUID> brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/new")
    public String createBrand() {
        return "brand-add";
    }

    @ModelAttribute("brandModel")
    public AddBrandDto initCompany() {
        return new AddBrandDto();
    }

    @PostMapping("/new")
    public String addCompany(@Valid AddBrandDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/new";
        }
        brandService.register(brandModel);

        return "redirect:/";
    }



//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBrand(@PathVariable UUID id) {
//        brandService.expel(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<BrandDto> getBrand(@PathVariable UUID id) {
//        return brandService.findBrand(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping
//    public ResponseEntity<List<BrandDto>> getAllBrands() {
//        List<BrandDto> brands = brandService.getAll();
//        return ResponseEntity.ok(brands);
//    }
}
