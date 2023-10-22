package org.example.services.impl;

import org.example.dtos.UserDto;
import org.example.models.User;
import org.example.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto register(UserDto user) {
        if(user.getId()!=null){
            user.setModified(new Date());
        }
        User u = modelMapper.map(user, User.class);
        return modelMapper.map(userRepository.save(u),UserDto.class);
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
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map((u) ->
                modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }
}
