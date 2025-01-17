package com.Todo.TaskDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/todoDetails")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //Add Task Details
    @PostMapping(path = "/addData")
    public ResponseEntity<?>adddata(@RequestBody TaskModel taskModel){
        try {
            return taskService.addData(taskModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Somethong Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //List All Task
    @GetMapping(path = "/list")
    public ResponseEntity<List<TaskModel>> addall(){
        return taskService.getallTasks();
    }


    //Update Task Status
    @PutMapping(path = "/update")
    public ResponseEntity<?>update(@RequestParam Integer id,@RequestParam String status){
        try {
            return taskService.update(id,status);
        }catch (Exception e){
            e.printStackTrace();
        }return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Delete Task
    @DeleteMapping(path = "/delete")
    public ResponseEntity<?>delete(@RequestParam Integer id){
        try {
            return taskService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
