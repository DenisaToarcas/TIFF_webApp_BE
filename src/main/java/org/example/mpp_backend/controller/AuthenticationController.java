package org.example.mpp_backend.controller;

import org.example.mpp_backend.dto.LoginUserDto;
import org.example.mpp_backend.dto.UserDto;
import org.example.mpp_backend.entities.LoginResponse;
import org.example.mpp_backend.entities.User;
import org.example.mpp_backend.service.AuthenticationService;
import org.example.mpp_backend.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api/authentication")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto) {
        User registerNewUser = authenticationService.signupUser(userDto);

        return ResponseEntity.ok(registerNewUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto userDto) {
        User loginUser = authenticationService.loginUser(userDto);

        String token = jwtService.generateToken(loginUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser_id(loginUser.getId());
        loginResponse.setToken(token);
        loginResponse.setExpires(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
