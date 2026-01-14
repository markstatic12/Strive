package com.strive.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.strive.backend.model.Task;
import com.strive.backend.model.User;
import com.strive.backend.repository.TaskRepository;

@Service

public class TaskService {

    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }


    
}
