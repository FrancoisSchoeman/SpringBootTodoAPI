package com.todoapi.todo_api.service;

import java.time.LocalDateTime;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.todoapi.todo_api.model.Todo;
import com.todoapi.todo_api.repository.TodoRepository;

@Slf4j
@Service
public class TodoService {

    @Autowired
    TodoRepository repository;

    public List<Todo> findAllTodos(){
        return repository.findAll();
    }

    public Todo findTodoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found."));
    }

    /**
     * Accepts a Todo object to persist and will return the created object
     *
     * @param todo - the Todo object of which only task is used
     * @return - the created todo object
     */
    public Todo createTodo(Todo todo){
        try {
            return repository.save(todo);
        } catch (Exception e) {
            log.error("Error creating the todo: ", e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Boolean todoExistsById(Integer id){
        return repository.existsById(id);
    }

    public void updateTodo(Todo todo){
        repository.save(todo);
    }

    public void deleteTodoById(Integer id){
        repository.deleteById(id);
    }

    public List<Todo> findTodosByStatus(Boolean isComplete){
        return repository.listByIsComplete(isComplete);
    }

}
