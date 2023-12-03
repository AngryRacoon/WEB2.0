package org.example.services.impl;

import org.example.dtos.AddModelDto;
import org.example.dtos.LightModelDto;
import org.example.dtos.ModelDto;
import org.example.models.Model;
import org.example.repositories.BrandRepository;
import org.example.repositories.ModelRepository;
import org.example.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService<UUID> {

    private ModelRepository modelRepository;


    private ModelMapper modelMapper;


    private BrandRepository brandRepository;

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Autowired
    public void setBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public AddModelDto register(AddModelDto model) {
        Model m = modelMapper.map(model, Model.class);
        m.setBrand(brandRepository.findByName(model.getBrandName()).orElse(null));
        return modelMapper.map(modelRepository.save(m),AddModelDto.class);
    }

    @Override
    public void expel(ModelDto model) {
        modelRepository.deleteById((model.getId()));
    }

    @Override
    public void expel(UUID id) {
        modelRepository.deleteById(id);
    }

    @Override
    public Optional<ModelDto> findModel(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id),ModelDto.class));
    }

    @Override
    public List<LightModelDto> getAll() {
        return modelRepository.findAll().stream().map((m) ->
                modelMapper.map(m, LightModelDto.class)).collect(Collectors.toList());
    }
}
