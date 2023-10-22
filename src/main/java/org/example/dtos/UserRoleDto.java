package org.example.dtos;

import org.example.models.User;
import org.example.models.enums.Role;

import java.util.Set;
import java.util.UUID;

public class UserRoleDto {
    private UUID id;
    private Role role;
    private Set<UserDto> users;
    public UserRoleDto(){}
    public UserRoleDto(Role role, Set<UserDto> users){
        this.role = role;
        this.users = users;
    }
    public UserRoleDto(Role role){
        this.role = role;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
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
