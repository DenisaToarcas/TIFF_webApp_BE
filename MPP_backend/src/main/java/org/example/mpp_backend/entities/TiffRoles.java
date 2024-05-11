package org.example.mpp_backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity     // This tells Hibernate to make a table out of this class
@Table (name = "tiff_roles")

public class TiffRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "roleType")
    private String type;

    @Column(name = "openRoles")
    private String openRoles;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "expectation")
    private String expectation;

    @OneToMany(mappedBy = "tiffRole", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tasks> tasks;
}
