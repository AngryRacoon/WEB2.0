package org.example.services.impl;

import org.example.dtos.AddModelDto;
import org.example.dtos.AddUserDto;
import org.example.dtos.LightUserDto;
import org.example.dtos.UserDto;
import org.example.models.Model;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRoleRepository;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService<UUID> {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AddUserDto register(AddUserDto user) {

        User u = modelMapper.map(user, User.class);
        u.setRole(userRoleRepository.findByRole (user.getRoleName()).orElse(null));
        u.setActive(false);
        return modelMapper.map(userRepository.save(u),AddUserDto.class);
    }

    @Override
    public void expel(UserDto user) {
        userRepository.deleteById((user.getId()));
    }

    @Override
    public void expel(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findUser(UUID id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id),UserDto.class));
    }

    @Override
    public List<LightUserDto> getAll() {
        return userRepository.findAll().stream().map((u) ->
                modelMapper.map(u, LightUserDto.class)).collect(Collectors.toList());
    }
}
