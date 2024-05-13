//package org.example.mpp_backend.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.example.mpp_backend.entities.User;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="roles")
//
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name="roleName", nullable = false, unique = true)
//    private String roleName;
//
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users;
//}
