package org.example.mpp_backend.service;

import lombok.AllArgsConstructor;
import org.example.mpp_backend.entities.TiffRoles;
import org.example.mpp_backend.repository.TiffRolesRepository;
import org.example.mpp_backend.repository.UserRepository;
import org.example.mpp_backend.validation.TasksValidation;
import org.example.mpp_backend.validation.TiffRoleValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TiffRolesService {
    private final TiffRolesRepository tiffRolesRepository;
    private final UserRepository userRepository;

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

    public List<TiffRoles> getTiffRolesFromUser(long user_id)
    {
        if (userRepository.getUserById(user_id) != null)
            return userRepository.getUserById(user_id).getTiffRoles();
        else
            throw new RuntimeException("There is no user with this id "+ user_id);
    }

    public TiffRoles addTiffRoles(long user_id, TiffRoles tiffRoles) {
        if (userRepository.getUserById(user_id) != null) {

            TiffRoleValidation.validateRole(tiffRoles);
            tiffRoles.setUser(userRepository.getUserById(user_id));
            tiffRolesRepository.save(tiffRoles);

            return tiffRoles;
        } else {
            throw new RuntimeException("There is no user with this id: " + user_id);
        }
    }

    public void addTiffRolesWithoutUser(TiffRoles tiffRoles)
    {
        TiffRoleValidation.validateRole(tiffRoles);
        tiffRolesRepository.save(tiffRoles);
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
