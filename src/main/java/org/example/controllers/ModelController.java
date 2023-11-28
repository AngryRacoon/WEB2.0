package org.example.controllers;

import org.example.dtos.ModelDto;
import org.example.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {


    private ModelService<UUID> modelService;
    @Autowired
    public void setModelService(ModelService<UUID> modelService) {
        this.modelService = modelService;
    }

    @PostMapping
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
    }
}
