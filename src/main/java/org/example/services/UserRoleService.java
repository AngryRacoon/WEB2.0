package org.example.services;

import org.example.dtos.UserRoleDto;

import java.util.List;
import java.util.Optional;

public interface UserRoleService<UUID>{
    UserRoleDto register(UserRoleDto userRole);
    void expel (UserRoleDto user);
    void expel(UUID id);
    Optional<UserRoleDto> findUserRole(UUID id);
    List<UserRoleDto> getAll();
}
