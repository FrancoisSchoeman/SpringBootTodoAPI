package com.todoapi.todo_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todoapi.todo_api.model.Todo;
import com.todoapi.todo_api.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodoController {
	private final TodoService service;

	public TodoController(TodoService service) {
		this.service = service;
	}

	@Operation(summary = "Get a list of all todo's.")
	@GetMapping("")
	public List<Todo> findAll(){
		return service.findAllTodos();
	}

	@Operation(summary = "Get a todo by id - add the id to the endpoint.")
	@GetMapping("/{id}")
	public Todo findById(@PathVariable Integer id){
		return service.findTodoById(id);
	}


	@Operation(summary = "Create a todo - pass a json object containing the task inside the request body, eg: {'task': 'Give cat milk!'}.")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void createTodo(@Valid @RequestBody Todo todo){
		service.createTodo(todo);
	}

	@Operation(summary = "Update a todo - pass a json object containing the id and task/isComplete inside the request body, eg: {'id': 1, 'task': 'Give cat less milk!', 'isComplete': true}.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("")
	public void updateTodo(@Valid @RequestBody Todo todo){
		service.updateTodo(todo);
	}

	@Operation(summary = "Delete a todo - pass a json object containing the id inside the request body, eg: {'id': 1}.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("")
	public void deleteTodo(@Valid @RequestBody Todo todo){
		service.deleteTodoById(todo.getId());
	}

	@Operation(summary = "Get a list of all todos that are either complete or not - pass a boolean value in the endpoint, eg: true.")
	@GetMapping("/filter/status/{isComplete}")
	public List<Todo> findByStatus(@PathVariable Boolean isComplete){
		return service.findTodosByStatus(isComplete);
	}
}
