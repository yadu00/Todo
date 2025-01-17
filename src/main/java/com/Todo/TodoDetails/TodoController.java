package com.Todo.TodoDetails;

import com.Todo.TaskDetails.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/taskTodoNew")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping(path = "/todoAdd")
    public ResponseEntity<?>add(@RequestBody TodoModel todoModel){
        try {
            return todoService.addData(todoModel);
         } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Somethong Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //List All Task
    @GetMapping(path = "/listTodo")
    public ResponseEntity<List<TodoModel>> addall(){
        return todoService.getallTasks();
    }
    @GetMapping(path = "/newlist")
    public ResponseEntity<List<TodoDto>>list(){
        return todoService.getall();
    }

    //Update Task Status
    @PutMapping(path = "/updateTodo")
    public ResponseEntity<?>update(@RequestParam Integer id,@RequestParam Integer status_id){
        try {
            return todoService.update(id,status_id);
        }catch (Exception e){
            e.printStackTrace();
        }return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Delete Task
    @DeleteMapping(path = "/deleteTodo")
    public ResponseEntity<?>delete(@RequestParam Integer id){
        try {
            return todoService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

