package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.AddBrandDto;
import org.example.dtos.BrandDto;
import org.example.dtos.LightBrandDto;
import org.example.services.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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
    @GetMapping("/edit/{id}")
    public String editBrand(@PathVariable UUID id, Model model) {
        Optional<LightBrandDto> b  = brandService.findLightBrand(id);
        model.addAttribute("brandModel", b.orElseThrow(() ->
                new NoSuchElementException("Value not present")));
        return "brand-edit";
    }

    @ModelAttribute("brandModel")
    public AddBrandDto initBrand() {
        return new AddBrandDto();
    }

    @PostMapping("/new")
    public String addBrand(@Valid AddBrandDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/new";
        }
        brandService.register(brandModel);

        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editBrand( @Valid LightBrandDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/edit/{id}";
        }
        brandService.edit(brandModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllCompanies(Model model) {
        model.addAttribute("brandInfos", brandService.getAll());
        return "brand-all";
    }


    @GetMapping("/{id}")
    public String brandDetails(@PathVariable("id") UUID id, Model model) {
        Optional<BrandDto> b  = brandService.findBrand(id);
        model.addAttribute("brandDetails", b.orElseThrow(() ->
                new NoSuchElementException("Value not present")));

        return "brand-details";
    }

    @GetMapping("delete/{id}")
    public String deleteBrand(@PathVariable ("id") UUID id) {
        brandService.expel(id);
        return "redirect:/brands/all";
    }
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
