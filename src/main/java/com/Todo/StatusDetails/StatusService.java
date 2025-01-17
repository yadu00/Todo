package com.Todo.StatusDetails;

import com.Todo.TaskDetails.TaskModel;
import com.Todo.TaskDetails.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepo;

    //Add Task Details
    public ResponseEntity<?> addData(StatusModel statusModel) {
        StatusModel statusModel1 =new StatusModel();
        statusModel1.setStatus(statusModel.getStatus());
        statusRepo.save(statusModel1);
        return new ResponseEntity<>(statusModel1, HttpStatus.OK);
    }

    //List All Task
    public ResponseEntity<List<StatusModel>> getallTasks() {
        List<StatusModel>statusModel=statusRepo.findAll();
        return new ResponseEntity<>(statusModel,HttpStatus.OK);
    }

}
