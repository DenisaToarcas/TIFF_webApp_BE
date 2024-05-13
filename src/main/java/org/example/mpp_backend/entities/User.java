package org.example.mpp_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="user_fullname", nullable=false)
    private String username;

    @Column(name="user_address", nullable=false)
    private String userAddress;

    @Column(name="user_cnp", nullable=false)
    private String userCnp;

    @Column(name ="user_email", nullable=false, unique=true)
    private String userEmail;

    @Column(name="user_password", nullable=false)
    private String userPassword;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name="roles",
//            joinColumns = {
//                    @JoinColumn(name="USER_ID", referencedColumnName = "ID")},
//            inverseJoinColumns = {
//                    @JoinColumn(name="ROLE_ID", referencedColumnName = "ID")
//            }
//    )
//    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
