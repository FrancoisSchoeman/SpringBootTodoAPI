package com.todoapi.todo_api.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

import com.todoapi.todo_api.model.Todo;

public interface TodoRepository extends ListCrudRepository<Todo, Integer> {

    @Query("SELECT * FROM Todo WHERE is_complete =:isComplete")
    List<Todo> listByIsComplete(Boolean isComplete);
    
}
