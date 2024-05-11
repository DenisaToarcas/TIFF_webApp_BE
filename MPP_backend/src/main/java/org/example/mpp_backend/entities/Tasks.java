package org.example.mpp_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity     // This tells Hibernate to make a table out of this class
@Table (name = "tasks")

public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_title")
    private String title;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_status")
    private String status;

    @Column(name = "task_priority")
    private String priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private TiffRoles tiffRole;
}
