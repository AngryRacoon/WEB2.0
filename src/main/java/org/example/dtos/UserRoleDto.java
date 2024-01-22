package org.example.dtos;

import org.example.models.User;
import org.example.models.enums.Role;

import java.util.Set;
import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private Role role;

    public UserRoleDto(){}

    public UserRoleDto(Role role){
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
