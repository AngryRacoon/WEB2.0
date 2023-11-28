package org.example.services;

import org.example.dtos.AddModelDto;
import org.example.dtos.ModelDto;

import java.util.List;
import java.util.Optional;

public interface ModelService<UUID>{

    AddModelDto register(AddModelDto model);

    void expel (ModelDto model);
    void expel(UUID id);
    Optional<ModelDto> findModel(UUID id);
    List<ModelDto> getAll();
}
