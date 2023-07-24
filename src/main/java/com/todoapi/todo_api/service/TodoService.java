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


    /**
     * Returns a list of all todos in the repository
     *
     * @return - a list of all todos
     */
    public List<Todo> findAllTodos(){
        return repository.findAll();
    }

    /**
     * Returns the Todo object with the given id
     *
     * @param id - the id of the todo to retrieve
     * @return - the Todo object with the given id
     * @throws ResponseStatusException - if the todo with the given id is not found
     */
    public Todo findTodoById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found."));
    }

    /**
     * Accepts a Todo object to persist and will return the created object
     *
     * @param todo - the Todo object of which only task is used
     * @return - the created todo object
     * @throws  - if there is an error in creating the todo
     */
    public Todo createTodo(Todo todo){
        try {
            // todo.setDateCreated(LocalDateTime.now());
            // todo.setIsComplete(false);
            return repository.save(todo);
        } catch (Exception e) {
            log.error("Error creating the todo: ", e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Checks if a todo with the given id exists in the repository
     *
     * @param id - the id of the todo to check
     * @return - true if the todo exists, false otherwise
     */
    public Boolean todoExistsById(Integer id){
        return repository.existsById(id);
    }


    /**
     * Updates the given Todo object in the repository
     *
     * @param todo - the Todo object to update
     */
    public void updateTodo(Todo todo){
        try{
            todo.setDateUpdated(LocalDateTime.now());
            repository.save(todo);
        } catch (Exception e) {
            log.error("Error updating the todo: ", e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Deletes the Todo object with the given id from the repository
     *
     * @param id - the id of the todo to delete
     * @throws ResponseStatusException - if the todo with the given id is not found
     */
    public void deleteTodoById(Integer id){
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting the todo: ", e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Returns a list of todos with the given completion status
     *
     * @param isComplete - the completion status of the todos to retrieve
     * @return - a list of todos with the given completion status
     */
    public List<Todo> findTodosByStatus(Boolean isComplete){
        return repository.listByIsComplete(isComplete);
    }

}
