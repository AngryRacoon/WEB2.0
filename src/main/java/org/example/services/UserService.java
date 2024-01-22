package org.example.services;

import jakarta.validation.Valid;
import org.example.dtos.AddUserDto;
import org.example.dtos.EditUserDto;
import org.example.dtos.LightUserDto;
import org.example.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService<UUID>{
    AddUserDto register(AddUserDto user);
    void expel (UserDto user);
    void expel(UUID id);
    Optional<UserDto> findUser(UUID id);
    List<LightUserDto> getAll();

    void edit(@Valid EditUserDto userDto);
}
