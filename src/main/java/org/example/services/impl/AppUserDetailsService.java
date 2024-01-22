package org.example.services.impl;

import org.example.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Collections;
import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName)
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + u.getRole().getRole().toString()))
                )).orElseThrow(() -> new UsernameNotFoundException(userName + " was not found!"));
    }

}


