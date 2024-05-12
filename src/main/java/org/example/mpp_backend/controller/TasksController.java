package org.example.mpp_backend.controller;

import org.example.mpp_backend.entities.Tasks;
import org.example.mpp_backend.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/tasks")
@RestController
public class TasksController {

    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService service) {
        this.tasksService = service;
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = tasksService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable long id) {
        Tasks task = tasksService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("{tiffRoleID}")
    public ResponseEntity<Tasks> addTask(@PathVariable long tiffRoleID, @RequestBody Tasks task) {
        Tasks addedTask  = tasksService.addTask(tiffRoleID, task);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable long id, @RequestBody Tasks task) {
        Tasks updatedTask = tasksService.updateTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Tasks>> deleteTask(@PathVariable long id) {
        tasksService.deleteTask(id);
        return new ResponseEntity<>(tasksService.getAllTasks(), HttpStatus.OK);
    }
}
