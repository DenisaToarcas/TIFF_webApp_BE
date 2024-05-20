package org.example.mpp_backend.controller;

import org.example.mpp_backend.entities.TiffRoles;
import org.example.mpp_backend.service.TiffRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/roles")
@RestController
public class TiffRolesController {

    private final TiffRolesService service;

    @Autowired
    public TiffRolesController(TiffRolesService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<TiffRoles> getRoleById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTiffRoleById(id));
    }

    @GetMapping
    public ResponseEntity<List<TiffRoles>> getRoles(@RequestParam(required = false, defaultValue = "false") String filtered) {
        if (filtered.equals("true")) {
            return ResponseEntity.ok(service.getAllTiffRoles());
        }
        else
            return ResponseEntity.ok(service.getAllTiffRoles());
    }

    @GetMapping("/user_id={user_id}")
    public ResponseEntity<List<TiffRoles>> getRolesFromUser(@PathVariable long user_id)
    {
        return ResponseEntity.ok(service.getTiffRolesFromUser(user_id));
    }

    @PostMapping("{user_id}")
    public ResponseEntity<TiffRoles> addRole(@PathVariable long user_id, @RequestBody TiffRoles role) {
        return new ResponseEntity<>(service.addTiffRoles(user_id, role), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TiffRoles> updateRole(@PathVariable long id, @RequestBody TiffRoles role) {
        return ResponseEntity.ok(service.updateTiffRoles(id, role));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<TiffRoles>> deleteRole(@PathVariable long id) {
        service.deleteTiffRoles(id);
        return ResponseEntity.ok(service.getAllTiffRoles());
    }
}
