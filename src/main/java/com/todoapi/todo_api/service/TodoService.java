package com.todoapi.todo_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.todoapi.todo_api.model.Comment;
import com.todoapi.todo_api.model.Todo;
import com.todoapi.todo_api.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAllTodos(){
        return repository.findAll();
    }

    public Todo findTodoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found."));
    }

    public void createTodo(String task){
        Todo todo = new Todo(null, task, false, LocalDateTime.now(), null);
        repository.save(todo);
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
