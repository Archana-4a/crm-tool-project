package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Task;

public interface TaskService {
	Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void deleteTask(Long id);
    long countTasks();
}
