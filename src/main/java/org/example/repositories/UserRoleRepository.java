package org.example.repositories;

import org.example.models.UserRole;
import org.example.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    Optional<UserRole> findByRole(Role roleEnum);
}
