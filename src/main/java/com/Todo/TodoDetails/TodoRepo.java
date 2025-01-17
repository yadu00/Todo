package com.Todo.TodoDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepo extends JpaRepository<TodoModel,Integer> {
}
