package com.Todo.TaskDetails;

import com.Todo.StatusDetails.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private StatusRepo statusRepo;

    //Add Task Details
    public ResponseEntity<?> addData(TaskModel taskModel) {
        TaskModel taskModel1 =new TaskModel();
        taskModel1.setDate(taskModel.getDate());
        taskModel1.setTask_name(taskModel.getTask_name());
        //taskModel1.setUpdated_date(taskModel.getUpdated_date());
        taskModel1.setStatus(taskModel.getStatus());
        taskRepo.save(taskModel1);
        return new ResponseEntity<>(taskModel1, HttpStatus.OK);
    }

    //List All Task
    public ResponseEntity<List<TaskModel>> getallTasks() {
        List<TaskModel>taskModel=taskRepo.findAll();
        return new ResponseEntity<>(taskModel,HttpStatus.OK);
    }

    //Update Task Status
    public ResponseEntity<?> update(Integer id, String status) {
            Optional<TaskModel> taskModelOptional=taskRepo.findById(id);

            if (taskModelOptional.isPresent()){
                TaskModel taskModel=taskModelOptional.get();
                taskModel.setUpdated_date(LocalDate.now());
                taskModel.setStatus(status);
                taskRepo.save(taskModel);
                return new ResponseEntity<>("Task status updated successfully",HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User Not found",HttpStatus.NOT_FOUND);
            }


    }

    //Delete Task
    public ResponseEntity<?> delete(Integer id) {
        Optional<TaskModel>taskModelOptional=taskRepo.findById(id);
        if (taskModelOptional.isPresent()){
            TaskModel taskModel=taskModelOptional.get();
            taskRepo.delete(taskModel);
            return new ResponseEntity<>("Task Deleted Successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not found",HttpStatus.NOT_FOUND);
        }
    }
}
