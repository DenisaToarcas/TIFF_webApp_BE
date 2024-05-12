package org.example.mpp_backend.validation;

import org.example.mpp_backend.entities.Tasks;

public class TasksValidation {

    public static void validateTasks(Tasks tasks) {

        if (tasks.getTitle() == null || tasks.getTitle().isEmpty()) {
            System.out.println(tasks.getId() + tasks.getTitle() + tasks.getDescription() +  tasks.getStatus() + tasks.getPriority());
            throw new RuntimeException("Title is required");
        }

        if (tasks.getDescription() == null || tasks.getDescription().isEmpty()) {
            throw new RuntimeException("Description is required");
        }

        if (tasks.getStatus() == null || tasks.getStatus().isEmpty()) {
            throw new RuntimeException("Status is required");
        }

        if (tasks.getPriority() == null || tasks.getPriority().isEmpty()) {
            throw new RuntimeException("Priority is required");
        }
    }
}
