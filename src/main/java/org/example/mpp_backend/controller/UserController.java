package org.example.mpp_backend.controller;

import org.example.mpp_backend.entities.User;
import org.example.mpp_backend.service.UserServiceHIHI;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserServiceHIHI userServiceHIHI;

    public UserController(UserServiceHIHI userServiceHIHI) {
        this.userServiceHIHI = userServiceHIHI;
    }

    @GetMapping("/personalInfo")
    public ResponseEntity<User> getPersonalInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) auth.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceHIHI.getAllUsers();

        return ResponseEntity.ok(users);
    }
}
