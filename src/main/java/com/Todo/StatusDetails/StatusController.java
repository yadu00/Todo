package com.Todo.StatusDetails;



import com.Todo.TaskDetails.TaskModel;
import com.Todo.TaskDetails.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/statusDetails")
public class StatusController {
    @Autowired
    private StatusService statusService;

    //Add Task Details
    @PostMapping(path = "/addData")
    public ResponseEntity<?> adddata(@RequestBody StatusModel statusModel){
        try {
            return statusService.addData(statusModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Somethong Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //List All Task
    @GetMapping(path = "/list")
    public ResponseEntity<List<StatusModel>> addall(){
        return statusService.getallTasks();
    }

}

