package org.example.mpp_backend;

import org.example.mpp_backend.entities.Tasks;
import org.example.mpp_backend.entities.TiffRoles;
import org.example.mpp_backend.repository.TasksRepository;
import org.example.mpp_backend.repository.TiffRolesRepository;
import org.example.mpp_backend.service.TasksService;
import org.example.mpp_backend.service.TiffRolesService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TaskServiceTests {

    @Mock
    private TasksRepository tasksRepository;

    @Mock
    private TiffRolesRepository tiffRolesRepository;

    @InjectMocks
    private TasksService tasksService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllTasks() {
        List<Tasks> tasks = new ArrayList<>();
        tasks.add(new Tasks());
        tasks.add(new Tasks());
        tasks.add(new Tasks());
        when(tasksRepository.findAll()).thenReturn(tasks);
        List<Tasks> result = tasksService.getAllTasks();
        assertFalse(result.isEmpty());
        assertEquals(tasks, result);
        assertEquals(tasks.size(), result.size());
        assertEquals(3, result.size());
    }

    @Test
    void getAllTasks_whenEmpty() {
        List<Tasks> tasks = new ArrayList<>();
        when(tasksRepository.findAll()).thenReturn(tasks);
        List<Tasks> result = tasksService.getAllTasks();
        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }

    @Test
    void getTaskById_whenTaskFound() {
        Long taskId = 1L;
        Tasks task = new Tasks();
        task.setId(taskId);

        when(tasksRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(tasksRepository.existsById(taskId)).thenReturn(true);

        Tasks result = tasksService.getTaskById(taskId);
        assertEquals(task, result);
        assertEquals(taskId, result.getId());
        assertNotNull(result);
    }

    @Test
    void getTaskById_whenTaskNotFound() {
        Long taskId = 2L;

        when(tasksRepository.findById(taskId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> tasksService.getTaskById(taskId));
    }

    @Test
    void testAddTask_whenRoleFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);

        task.setTiffRole(tiffRole);

        when(tiffRolesRepository.findById(tiffRole.getId())).thenReturn(Optional.of(tiffRole));
        when(tiffRolesRepository.existsById(tiffRole.getId())).thenReturn(true);
        when(tasksRepository.save(task)).thenReturn(task);

        Tasks result = tasksService.addTask(tiffRole.getId(), task);
        assertEquals(task, result);
        assertNotNull(result);
        verify(tasksRepository).save(task);
    }

    @Test
    void testAddTask_whenRoleNotFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);

        task.setTiffRole(tiffRole);

        when(tiffRolesRepository.findById(tiffRole.getId())).thenReturn(Optional.empty());

        when(tasksRepository.save(task)).thenReturn(task);

        assertThrows(RuntimeException.class, () -> tasksService.addTask(tiffRole.getId(), task));
    }

    @Test
    void testUpdateTask_whenTaskFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);
        task.setTiffRole(tiffRole);

        when(tasksRepository.findById(task.getId())).thenReturn(Optional.of(task));
        when(tasksRepository.existsById(task.getId())).thenReturn(true);
        when(tasksRepository.save(task)).thenReturn(task);

        Tasks updatedTask = new Tasks();
        updatedTask.setId(2L);
        updatedTask.setTitle("updated title");
        updatedTask.setDescription("updated description");
        updatedTask.setPriority("updated priority");
        updatedTask.setStatus("updated status");

        Tasks result = tasksService.updateTask(task.getId(), updatedTask);
        assertEquals(updatedTask.getTitle(), result.getTitle());
        assertEquals(updatedTask.getDescription(), result.getDescription());
        assertEquals(updatedTask.getPriority(), result.getPriority());
        assertEquals(updatedTask.getStatus(), result.getStatus());
        assertNotNull(result);
    }

    @Test
    void testUpdateTask_whenTaskNotFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);
        task.setTiffRole(tiffRole);

        when(tasksRepository.findById(task.getId())).thenReturn(Optional.empty());

        Tasks updatedTask = new Tasks();
        updatedTask.setId(2L);
        updatedTask.setTitle("updated title");
        updatedTask.setDescription("updated description");
        updatedTask.setPriority("updated priority");
        updatedTask.setStatus("updated status");

        assertThrows(RuntimeException.class, () -> tasksService.updateTask(task.getId(), updatedTask));
    }

    @Test
    void testDeleteTask_whenTaskFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);
        task.setTiffRole(tiffRole);

        when(tasksRepository.findById(task.getId())).thenReturn(Optional.of(task));
        when(tasksRepository.existsById(task.getId())).thenReturn(true);

        tasksService.deleteTask(task.getId());
        verify(tasksRepository).deleteById(task.getId());
    }

    @Test
    void testDeleteTask_whenTaskNotFound()
    {
        Tasks task = new Tasks();
        task.setId(1L);
        task.setTitle("test title");
        task.setDescription("test description");
        task.setPriority("test priority");
        task.setStatus("test status");

        TiffRoles tiffRole = new TiffRoles();
        tiffRole.setId(1L);
        task.setTiffRole(tiffRole);

        when(tasksRepository.findById(task.getId())).thenReturn(Optional.empty());
        when(tasksRepository.existsById(task.getId())).thenReturn(false);

        assertThrows(RuntimeException.class, () -> tasksService.deleteTask(task.getId()));
    }
}
