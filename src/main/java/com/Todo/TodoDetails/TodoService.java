package com.Todo.TodoDetails;

import com.Todo.StatusDetails.StatusModel;
import com.Todo.StatusDetails.StatusRepo;
import com.Todo.TaskDetails.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private StatusRepo statusRepo;

    public ResponseEntity<?> addData(TodoModel todoModel) {
        TodoModel todoModel1=new TodoModel();
        todoModel1.setDate(todoModel.getDate());
        todoModel1.setTask_name(todoModel.getTask_name());
        todoRepo.save(todoModel1);
        return new ResponseEntity<>(todoModel1, HttpStatus.OK);
    }

    public ResponseEntity<List<TodoModel>> getallTasks() {
        List<TodoModel>todoModel=todoRepo.findAll();
        return new ResponseEntity<>(todoModel,HttpStatus.OK);
    }

    public ResponseEntity<?> update(Integer id, Integer status_id) {
        Optional<TodoModel> todoModelOptional=todoRepo.findById(id);
        Optional<StatusModel> statusModelOptional=statusRepo.findById(status_id);
        if (statusModelOptional.isPresent()){
            if (todoModelOptional.isPresent()) {
                TodoModel todoModel = todoModelOptional.get();
                todoModel.setUpdated_date(LocalDate.now());
                todoModel.setStatus_id(status_id);
                todoRepo.save(todoModel);
                return new ResponseEntity<>("Task status updated",HttpStatus.OK);
            }else
            return new ResponseEntity<>("Task Not found",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Status Not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(Integer id) {
        Optional<TodoModel>todoModelOptional=todoRepo.findById(id);
        if (todoModelOptional.isPresent()){
            TodoModel todoModel=todoModelOptional.get();
            todoRepo.delete(todoModel);
            return new ResponseEntity<>("Task Deleted Successfully",HttpStatus.OK);
        }else{
        return new ResponseEntity<>("User Not found",HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<List<TodoDto>> getall() {
        List<TodoDto> todoDtos = new ArrayList<>();

        List<TodoModel> todoModels = todoRepo.findAll();
        List<StatusModel> statusModels = statusRepo.findAll();
        TodoDto todoDto = new TodoDto();
        if (!todoModels.isEmpty()) {
            for (TodoModel todoModel : todoModels) {

                todoDto.setTask_id(todoModel.getId());
                todoDto.setTask_start_date(todoModel.getDate());
                todoDto.setTask_name(todoModel.getTask_name());
                todoDto.setUpdated_date(todoModel.getUpdated_date());
                todoDto.setStatus_id(todoModel.getStatus_id());
                //todoDtos.add(todoDto);
                Optional<StatusModel>statusModelOptional=statusRepo.findById();
            }
            for (StatusModel statusModel:statusModels){
                todoDto.setStatus_name(statusModel.getStatus());
            }
            return new ResponseEntity<>(todoDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(todoDtos, HttpStatus.NOT_FOUND);
    }
}
