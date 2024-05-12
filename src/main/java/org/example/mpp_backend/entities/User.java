package org.example.mpp_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")

public class User {
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="roles",
            joinColumns = {
                    @JoinColumn(name="USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                    @JoinColumn(name="ROLE_ID", referencedColumnName = "ID")
            }
    )
    private List<Role> roles;
}
