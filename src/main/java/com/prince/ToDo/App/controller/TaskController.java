package com.prince.ToDo.App.controller;

import com.prince.ToDo.App.entity.Task;
import com.prince.ToDo.App.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/get")
    public List<Task> getTask(){
        List<Task> allTask = taskService.getAllTask();
        return allTask;
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping("/create")
    public Task create(@RequestBody Task task){
           return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task){
         return taskService.updateTasks(id,task);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id){
         return taskService.deleteTasks(id);
    }

}
