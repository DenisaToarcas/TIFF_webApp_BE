package org.example.mpp_backend.validation;

import org.example.mpp_backend.entities.TiffRoles;

public class TiffRoleValidation {
    public static void validateRole(TiffRoles role)
    {
        if (role.getRoleName() ==  null)
            throw new RuntimeException("Role name is null");

        if (role.getOpenRoles() == null)
            throw new RuntimeException("Open Roles is null");

        if (role.getType() == null)
            throw new RuntimeException("Type is null");

        if (role.getSchedule() == null)
            throw new RuntimeException("Schedule is null");

        if (role.getExpectation() == null)
            throw new RuntimeException("Expectation is null");

        if (role.getRoleName().isEmpty())
            throw new RuntimeException("Role name is empty");

        if (role.getType().isEmpty())
            throw new RuntimeException("Role type is empty");

        if (role.getOpenRoles().isEmpty())
            throw new RuntimeException("Open roles is empty");

        if (role.getSchedule().isEmpty())
            throw new RuntimeException("Schedule is empty");

        if (role.getExpectation().isEmpty())
            throw new RuntimeException("Expectation is empty");
    }
}
