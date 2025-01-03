package com.prince.ToDo.App.service;

import com.prince.ToDo.App.entity.Task;
import com.prince.ToDo.App.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    //find all task
    public List<Task> getAllTask(){
        List<Task> all = taskRepository.findAll();
        return all;
    }


    //Find task by id
    public Task findTaskById(Long id){
        Optional<Task> byId = taskRepository.findById(id);
        return byId.get();
    }


    //Create Task
    public Task createTask(Task task){
            return taskRepository.save(task);
    }


//Update Task By Id
    public Task updateTasks(Long id,Task task){
        Optional<Task> taskById = taskRepository.findById(id);

        Task tsk=null;

        if(taskById.isPresent()){
            Task dbTaskObj=taskById.get();
            dbTaskObj.setStatus(task.getStatus());
            tsk=taskRepository.save(dbTaskObj);

        }else{
            System.out.println("Data not present in db....");
        }
       return tsk;
    }


    //Delete Task By Id
    public Task deleteTasks(Long id){
        Optional<Task> taskById=taskRepository.findById(id);
        Task tsk=taskById.get();

        if(taskById.isPresent()){
           taskRepository.deleteById(id);

        }else{
            System.out.println("Data not present in db....");
            return null;
        }
       return tsk;
    }

}
