package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.*;
import org.example.services.BrandService;
import org.example.services.ModelService;
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
@RequestMapping("/models")
public class ModelController {


    private ModelService<UUID> modelService;
    private BrandService<UUID> brandService;
    @Autowired
    public void setModelService(ModelService<UUID> modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setBrandService(BrandService<UUID> brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/new")
    public String addModel(Model model) {
        model.addAttribute("availableBrand", brandService.getAll());
        return "model-add";
    }
    @GetMapping("/edit/{id}")
    public String editBrand(@PathVariable UUID id, Model model) {
        model.addAttribute("availableBrand", brandService.getAll());
        Optional<ModelDto> m  = modelService.findModel(id);
        model.addAttribute("modelModel", m.orElseThrow(() ->
                new NoSuchElementException("Value not present")));
        return "model-edit";
    }

    @ModelAttribute("modelModel")
    public AddModelDto initModel() {
        return new AddModelDto();
    }

    @PostMapping("/new")
    public String addModel(@Valid AddModelDto modelModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelModel", modelModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel",
                    bindingResult);
            return "redirect:/models/new";
        }
        modelService.register(modelModel);

        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editModel(@Valid ModelDto modelModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", modelModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel",
                    bindingResult);
            return "redirect:/models/edit/{id}";
        }
        modelService.edit(modelModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllCompanies(Model model) {
        model.addAttribute("modelInfos", modelService.getAll());
        return "model-all";
    }

    @GetMapping("/{id}")
    public String modelDetails(@PathVariable("id") UUID id, Model model) {
        Optional<ModelDto> m = modelService.findModel(id);
        model.addAttribute("modelDetails", m.orElseThrow(() ->
                new NoSuchElementException("Value not present")));

        return "model-details";
    }

    @GetMapping("delete/{id}")
    public String deleteModel(@PathVariable ("id") UUID id) {
        modelService.expel(id);
        return "redirect:/models/all";
    }

}
