package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.AddModelDto;
import org.example.dtos.ModelDto;
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

    @GetMapping("/all")
    public String showAllCompanies(Model model) {
        model.addAttribute("modelInfos", modelService.getAll());
        return "model-all";
    }


/*    @PostMapping
    public ResponseEntity<ModelDto> createModel(@RequestBody ModelDto modelDto) {
        ModelDto createdModel = modelService.register(modelDto);
        return ResponseEntity.ok(createdModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable UUID id) {
        modelService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDto> getModel(@PathVariable UUID id) {
        return modelService.findModel(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> getAllModels() {
        List<ModelDto> models = modelService.getAll();
        return ResponseEntity.ok(models);
    }*/
}
