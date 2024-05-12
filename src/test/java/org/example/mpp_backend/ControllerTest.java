/*
package org.example.mpp_backend;

import org.example.mpp_backend.controller.Controller;
import org.example.mpp_backend.model.TIFFRoles;
import org.example.mpp_backend.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ControllerTest {

    //we mock the Service
    @Mock
    private Service service;

    //it injects a mock Service object into the Controller class.
    @InjectMocks
    private Controller controller;

    //this annotated method should be executed before each test method in the class (it runs before each test method)
    //it initializes the mock objects annotated with @Mock before each test
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRoleById() {
        int roleId = 1;
        TIFFRoles expectedRole = new TIFFRoles(roleId, "Test Role", "Test Type", "Test Open Roles", "Test Schedule", "Test Expectation");
        when(service.getByID(roleId)).thenReturn(expectedRole);

        ResponseEntity<TIFFRoles> response = controller.getRoleById(roleId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedRole, response.getBody());
    }

    @Test
    void testGetAllRoles() {
        List<TIFFRoles> expectedRoles = List.of(
                new TIFFRoles(1, "Role 1", "Type 1", "Open Roles 1", "Schedule 1", "Expectation 1"),
                new TIFFRoles(2, "Role 2", "Type 2", "Open Roles 2", "Schedule 2", "Expectation 2")
        );
        when(service.getAllRoles()).thenReturn(expectedRoles);

        ResponseEntity<List<TIFFRoles>> response = controller.getRoles("false");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedRoles, response.getBody());
    }

    @Test
    void testAddRole() {
        TIFFRoles newRole = new TIFFRoles(1, "New Role", "New Type", "New Open Roles", "New Schedule", "New Expectation");
        when(service.addRole(newRole)).thenReturn(newRole);

        ResponseEntity<TIFFRoles> response = controller.addRole(newRole);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newRole, response.getBody());
    }

    @Test
    void testUpdateRole() {
        int roleId = 1;
        TIFFRoles updatedRole = new TIFFRoles(roleId, "Updated Role", "Updated Type", "Updated Open Roles", "Updated Schedule", "Updated Expectation");
        when(service.updateRole(roleId, updatedRole)).thenReturn(updatedRole);

        ResponseEntity<TIFFRoles> response = controller.updateRole(roleId, updatedRole);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedRole, response.getBody());
    }

    @Test
    void testDeleteRole() {
        int roleId = 1;

        List<TIFFRoles> expectedRoles = List.of(
                new TIFFRoles(1, "Role 1", "Type 1", "Open Roles 1", "Schedule 1", "Expectation 1")
                );
        when(service.getAllRoles()).thenReturn(expectedRoles);

        controller.addRole(new TIFFRoles(1, "Role 1", "Type 1", "Open Roles 1", "Schedule 1", "Expectation 1"));
        controller.addRole(new TIFFRoles(2, "Role 2", "Type 2", "Open Roles 2", "Schedule 2", "Expectation 2"));

        ResponseEntity<List<TIFFRoles>> response = controller.deleteRole(roleId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedRoles, response.getBody());
    }

    */
/*
    Each test method corresponds to a method in the Controller class and verifies its behavior under certain conditions.
    Each test method starts by setting up the expected behavior of the mock Service object using Mockito's when method.
    Then, it calls the corresponding method in the Controller class and captures the response.
    Finally, it asserts that the response matches the expected outcome.
     *//*

}
*/
