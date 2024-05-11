package org.example.mpp_backend.service;

import lombok.AllArgsConstructor;
import org.example.mpp_backend.entities.TiffRoles;
import org.example.mpp_backend.repository.TiffRolesRepository;
import org.example.mpp_backend.validation.TiffRoleValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TiffRolesService {
    private final TiffRolesRepository tiffRolesRepository;

    public List<TiffRoles> getAllTiffRoles() {
        return tiffRolesRepository.findAll();
    }

    public TiffRoles getTiffRoleById(long id) {
        if (!tiffRolesRepository.existsById(id)) {
            throw new RuntimeException("The id " + id + " does not exist");
        } else {
            return tiffRolesRepository.findById(id).get();
        }
    }

    public TiffRoles addTiffRoles(TiffRoles tiffRoles) {
        return tiffRolesRepository.save(tiffRoles);
    }

    public TiffRoles updateTiffRoles(long id, TiffRoles updatedTiffRole) {
        if (!tiffRolesRepository.existsById(id)) {
            throw new RuntimeException("The id " + id + " does not exist");
        } else {
            TiffRoleValidation.validateRole(updatedTiffRole);

            TiffRoles role = tiffRolesRepository.findById(id).get();

            role.setRoleName(updatedTiffRole.getRoleName());
            role.setType(updatedTiffRole.getType());
            role.setOpenRoles(updatedTiffRole.getOpenRoles());
            role.setSchedule(updatedTiffRole.getSchedule());
            role.setExpectation(updatedTiffRole.getExpectation());
            role.setTasks(updatedTiffRole.getTasks());

            return tiffRolesRepository.save(role);
        }
    }

    public void deleteTiffRoles(long id) {
        if (!tiffRolesRepository.existsById(id)) {
            throw new RuntimeException("The id " + id + " does not exist");
        }
        else {
            tiffRolesRepository.deleteById(id);
        }
        }
    }
