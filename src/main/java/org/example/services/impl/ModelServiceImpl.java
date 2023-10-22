package org.example.services.impl;

import org.example.dtos.ModelDto;
import org.example.models.Model;
import org.example.repositories.ModelRepository;
import org.example.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService<UUID> {
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ModelDto register(ModelDto model) {
        if(model.getId()!=null){
            model.setModified(new Date());
        }
        Model m = modelMapper.map(model, Model.class);
        return modelMapper.map(modelRepository.save(m),ModelDto.class);
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
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((m) ->
                modelMapper.map(m, ModelDto.class)).collect(Collectors.toList());
    }
}
