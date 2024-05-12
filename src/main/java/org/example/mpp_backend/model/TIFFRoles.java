package org.example.mpp_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TIFFRoles {
    private int id;
    private String roleName;
    private String type;
    private String openRoles;
    private String schedule;
    private String expectation;
}
