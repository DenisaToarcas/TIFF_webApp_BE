package org.example.mpp_be.controller;

import org.example.mpp_be.model.TIFFRoles;
import org.example.mpp_be.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/roles")
@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<TIFFRoles> getRoleById(@PathVariable int id) {
        return ResponseEntity.ok(service.getByID(id));
    }

    @GetMapping
    public ResponseEntity<List<TIFFRoles>> getRoles(@RequestParam(required = false, defaultValue = "false") String filtered) {
        if (filtered.equals("true")) {
            return ResponseEntity.ok(service.filterRoles());
        }
        else
            return ResponseEntity.ok(service.getAllRoles());
    }

    @PostMapping
    public ResponseEntity<TIFFRoles> addRole(@RequestBody TIFFRoles role) {
        return new ResponseEntity<>(service.addRole(role), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TIFFRoles> updateRole(@PathVariable int id, @RequestBody TIFFRoles role) {
        return ResponseEntity.ok(service.updateRole(id, role));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<TIFFRoles>> deleteRole(@PathVariable int id) {
        service.removeRole(id);
        return ResponseEntity.ok(service.getAllRoles());
    }
}
