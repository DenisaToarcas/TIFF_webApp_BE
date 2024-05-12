package org.example.mpp_backend.service;

import lombok.AllArgsConstructor;
import org.example.mpp_backend.entities.Tasks;
import org.example.mpp_backend.repository.TasksRepository;
import org.example.mpp_backend.repository.TiffRolesRepository;
import org.example.mpp_backend.validation.TasksValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TasksService {
    private TasksRepository tasksRepository;
    private TiffRolesRepository tiffRolesRepository;

    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }

    public Tasks getTaskById(long id){
        if (tasksRepository.existsById(id)){
            return tasksRepository.findById(id).get();
        }
        else {
            throw new RuntimeException("There is no Tasks with this id: " + id);
        }
    }

    public Tasks addTask(Long tiffRoleId, Tasks task) {
        if (tiffRolesRepository.existsById(tiffRoleId)) {

            TasksValidation.validateTasks(task);
            task.setTiffRole(tiffRolesRepository.findById(tiffRoleId).get());
            tasksRepository.save(task);

            return task;
        } else {
            throw new RuntimeException("There is no tiff role with this id: " + tiffRoleId);
        }
    }

    public Tasks updateTask(long id, Tasks updatedTask) {
        if (tasksRepository.existsById(id)) {
            TasksValidation.validateTasks(updatedTask);

            Tasks task = tasksRepository.findById(id).get();

            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setPriority(updatedTask.getPriority());

            return tasksRepository.save(task);
        }
        else {
            throw new RuntimeException("There is no Tasks with this id: " + id);
    }
    }

    public void deleteTask(long id) {
        if (tasksRepository.existsById(id)) {
            tasksRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("There is no Tasks with this id: " + id);
        }
    }
}
