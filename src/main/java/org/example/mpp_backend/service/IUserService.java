package org.example.mpp_backend.service;

import org.example.mpp_backend.entities.User;
import org.example.mpp_backend.entities.UserDto;

import java.util.List;

public interface IUserService {

    void saveUser(UserDto dto);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    List<UserDto> findAllUsers();
}
