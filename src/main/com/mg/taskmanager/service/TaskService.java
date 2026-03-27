package com.mg.taskmanager.service;

public interface TaskService {
    
    List<Task> getAll();

    Task save(Task task);

    void delete(Long id);
}
