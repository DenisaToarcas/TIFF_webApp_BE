package org.example.mpp_backend.dto;

//import org.example.mpp_backend.entities.Role;
import org.example.mpp_backend.entities.User;

//import java.util.List;

public class UserDto {
    public Long id;
    public String username;
    public String address;
    public String CNP;
    public String email;
    public String password;
    //public List<String> roles;

    public static UserDto fromUser(User user) {
        UserDto dto = new UserDto();
        dto.id = user.getId();
        dto.username = user.getUsername();
        dto.address = user.getUserAddress();
        dto.CNP = user.getUserCnp();
        dto.email = user.getUserEmail();
        dto.password = user.getUserPassword();
//        dto.roles = user.getRoles().stream().map(
//                Role::getRoleName
//        ).toList();

        return dto;
    }
}
