package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/tasks")
public class TaskController {
	
         @Autowired
	    private TaskService taskService;
         @Autowired
         private UserService userService;


	   /* @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return taskService.saveTask(task);
	    }*/
         @PostMapping("/{userId}")
         public Task createTask(@RequestBody Task task, @PathVariable Long userId) {
           //  Long userId = task.getAssignedTo().getId();
        	 System.out.println(task);
             User user = userService.getUserById(userId); // fetch the full User object
             task.setAssignedTo(user); // set full User
             return taskService.saveTask(task);
         }


	    @GetMapping
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	    }

	    @GetMapping("/{id}")
	    public Task getTaskById(@PathVariable Long id) {
	        return taskService.getTaskById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	    }
}
