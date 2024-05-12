package org.example.mpp_backend.service;

import org.example.mpp_backend.model.TIFFRoles;
import org.example.mpp_backend.repository.Repository;
import org.example.mpp_backend.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public TIFFRoles addRole(TIFFRoles role) {
        TIFFRoles newRole = new TIFFRoles(repository.freeID(), role.getRoleName(), role.getType(), role.getOpenRoles(), role.getSchedule(), role.getExpectation());
        Validation.validateRole(newRole);
        repository.add(newRole);

        return newRole;
    }

    public TIFFRoles getByID(int id) {
        if (repository.contains(id))
            return repository.getByID(id);
        else
            throw new RuntimeException("ID not found!");
    }

    public List<TIFFRoles> getAllRoles()
    {
        return repository.getAll();
    }

    public void removeRole(int id) {
        if (repository.contains(id))
            repository.delete(id);
        else
            throw new RuntimeException("ID not found!");
    }

    public TIFFRoles updateRole(int ID, TIFFRoles role) {
        if (repository.contains(ID)) {
            Validation.validateRole(role);
            return repository.update(ID, role);
        }
        else
            throw new RuntimeException("ID not found!");
    }

    public List<TIFFRoles> filterRoles()
    {
        List<TIFFRoles> filteredRoles = new ArrayList<TIFFRoles>();
        for (TIFFRoles role : getAllRoles())
            if (role.getRoleName().length() > 3)
                filteredRoles.add(role);

        return filteredRoles;
    }
}
