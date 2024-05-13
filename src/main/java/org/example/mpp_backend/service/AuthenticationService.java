package org.example.mpp_backend.service;

import org.example.mpp_backend.dto.LoginUserDto;
import org.example.mpp_backend.entities.User;
//import org.example.mpp_backend.entities.Role;
import org.example.mpp_backend.dto.UserDto;
import org.example.mpp_backend.repository.UserRepository;
//import org.example.mpp_backend.repository.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    //private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

//    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.authenticationManager = authenticationManager;
//    }
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signupUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username);
        user.setUserAddress(userDto.address);
        user.setUserCnp(userDto.CNP);
        user.setUserEmail(userDto.email);

        //encrypt password using spring security
        user.setUserPassword(passwordEncoder.encode(userDto.password));

//        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
//        if (role == null) {
//            role = checkRoleExists();
//        }
//        user.setRoles(List.of(role));
//        role.getUsers().add(user);
//        roleRepository.saveAndFlush(role);
        return userRepository.save(user);
    }

    public User loginUser(LoginUserDto userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.email, userDto.password));

        return userRepository.findByUserEmail(userDto.email).orElseThrow();
    }

//    private Role checkRoleExists() {
//        Role role = new Role();
//        role.setRoleName("ROLE_ADMIN");
//       return roleRepository.save(role);
//    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapUserToDto).collect(Collectors.toList());
    }

    private UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.username = user.getUsername();
        userDto.address = user.getUserAddress();
        userDto.CNP = user.getUserCnp();
        userDto.email = user.getUserEmail();
        userDto.password = user.getUserPassword();
        return userDto;
    }
}
