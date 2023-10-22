package org.example.services.impl;


import org.example.dtos.UserRoleDto;
import org.example.models.UserRole;
import org.example.repositories.UserRoleRepository;
import org.example.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService<UUID> {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserRoleDto register(UserRoleDto userRole) {
        UserRole u = modelMapper.map(userRole, UserRole.class);
        return modelMapper.map(userRoleRepository.save(u),
                UserRoleDto.class);
    }

    @Override
    public void expel(UserRoleDto userRole) {
        userRoleRepository.deleteById((userRole.getId()));
    }

    @Override
    public void expel(UUID id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public Optional<UserRoleDto> findUserRole(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRoleRepository.findById(id),UserRoleDto.class));
    }

    @Override
    public List<UserRoleDto> getAll() {
        return userRoleRepository.findAll().stream().map((u) ->
                modelMapper.map(u, UserRoleDto.class)).collect(Collectors.toList());
    }
}
