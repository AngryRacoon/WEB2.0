package org.example.services;

import org.example.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService<UUID>{
    UserDto register(UserDto user);
    void expel (UserDto user);
    void expel(UUID id);
    Optional<UserDto> findUser(UUID id);
    List<UserDto> getAll();
}
