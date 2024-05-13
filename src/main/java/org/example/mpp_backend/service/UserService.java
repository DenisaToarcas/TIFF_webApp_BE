//package org.example.mpp_backend.service;
//
//import org.example.mpp_backend.entities.User;
//import org.example.mpp_backend.entities.Role;
//import org.example.mpp_backend.dto.UserDto;
//import org.example.mpp_backend.repository.UserRepository;
//import org.example.mpp_backend.repository.RoleRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService implements IUserService {
//
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void saveUser(UserDto userDto) {
//        User user = new User();
//        user.setUsername(userDto.username);
//        user.setUserAddress(userDto.address);
//        user.setUserCnp(userDto.CNP);
//        user.setUserEmail(userDto.email);
//
//        //encrypt password using spring security
//        user.setUserPassword(passwordEncoder.encode(userDto.password));
//
//        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
//        if (role == null) {
//            role = checkRoleExists();
//        }
//        user.setRoles(List.of(role));
//        userRepository.save(user);
//    }
//
//    private Role checkRoleExists() {
//        Role role = new Role();
//        role.setRoleName("ROLE_ADMIN");
//        return roleRepository.save(role);
//    }
//
//    @Override
//    public User findUserByEmail(String email) {
//        return userRepository.findByUserEmail(email);
//    }
//
//    @Override
//    public User findUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public List<UserDto> findAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream().map(this::mapUserToDto).collect(Collectors.toList());
//    }
//
//    private UserDto mapUserToDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.id = user.getId();
//        userDto.username = user.getUsername();
//        userDto.address = user.getUserAddress();
//        userDto.CNP = user.getUserCnp();
//        userDto.email = user.getUserEmail();
//        userDto.password = user.getUserPassword();
//        return userDto;
//    }
//}
