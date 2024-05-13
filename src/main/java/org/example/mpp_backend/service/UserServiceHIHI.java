package org.example.mpp_backend.service;

import org.example.mpp_backend.entities.User;
import org.example.mpp_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceHIHI {
    private final UserRepository userRepository;

    public UserServiceHIHI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
