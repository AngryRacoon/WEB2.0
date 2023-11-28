package org.example.controllers;

import org.example.dtos.UserRoleDto;
import org.example.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {


    private UserRoleService<UUID> userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService<UUID> userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<UserRoleDto> createUserRole(@RequestBody UserRoleDto userRoleDto) {
        UserRoleDto newUserRole = userRoleService.register(userRoleDto);
        return ResponseEntity.ok(newUserRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable UUID id) {
        userRoleService.expel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDto> getUserRole(@PathVariable UUID id) {
        return userRoleService.findUserRole(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserRoleDto>> getAllUserRoles() {
        List<UserRoleDto> userRoles = userRoleService.getAll();
        return ResponseEntity.ok(userRoles);
    }
}
