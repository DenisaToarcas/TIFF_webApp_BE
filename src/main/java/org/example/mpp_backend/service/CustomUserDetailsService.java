//package org.example.mpp_backend.service;
//
//import com.corundumstudio.socketio.annotation.OnEvent;
//import org.example.mpp_backend.entities.Role;
//import org.example.mpp_backend.entities.User;
//import org.example.mpp_backend.dto.UserDto;
//import org.example.mpp_backend.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByUserEmail(email);
//
//        if (user == null) {
////            throw new UsernameNotFoundException("Invalid user email " + email);
//        }
//        else
//        {
//            return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), mapRolesToAuthorise(user.getRoles()));
//        }
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorise(Collection<Role> roles) {
//        Collection <? extends GrantedAuthority> mapRoles = roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(Collectors.toList());
//
//        return mapRoles;
//    }
//}
