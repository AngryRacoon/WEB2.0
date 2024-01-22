package org.example.services.impl;

import org.example.dtos.AddUserDto;
import org.example.models.User;
import org.example.models.enums.Role;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;


    private PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void register(AddUserDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

/*        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }*/

        var userRole = userRoleRepository.
                findByRole(Role.USER).orElseThrow();

        User user = new User(
                registrationDTO.getUsername(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getFirstName(),
                registrationDTO.getLastName(),
                true,
                registrationDTO.getImageUrl()
        );

        user.setRole(userRole);

        this.userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
    public void createAdminUser() {
        User adminUser = new User(
                "Admin",
                passwordEncoder.encode("Admin"),
                "Admin",
                "Admin",
                true,
                "https://www.pngitem.com/pimgs/m/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        );

        var adminRole = userRoleRepository.findByRole(Role.ADMIN).orElseThrow();
        adminUser.setRole(adminRole);

        this.userRepository.save(adminUser);
    }

}
