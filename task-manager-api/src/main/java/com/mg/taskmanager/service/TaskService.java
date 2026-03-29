package com.mg.taskmanager.service;

import com.mg.taskmanager.model.Task;
import java.util.List;

public interface TaskService {
    
    List<Task> getAll();

    Task save(Task task);

    void delete(Long id);
}
