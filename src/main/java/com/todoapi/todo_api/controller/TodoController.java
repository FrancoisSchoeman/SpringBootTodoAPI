package com.todoapi.todo_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todoapi.todo_api.model.Todo;
import com.todoapi.todo_api.repository.TodoRepository;

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
	private final TodoRepository repository;

	public TodoController(TodoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<Todo> findAll(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Todo findById(@PathVariable Integer id){
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found."));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void createTodo(@Valid @RequestBody Todo todo){
		repository.save(todo);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void updateTodo(@RequestBody Todo todo, @PathVariable Integer id){

		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found.");
		}

		repository.save(todo);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Integer id){

		if(!repository.existsById(id)){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "To do not found.");
		}

		repository.deleteById(id);
	}

	@GetMapping("/filter/status/{isComplete}")
	public List<Todo> findByStatus(@PathVariable Boolean isComplete){
		return repository.listByIsComplete(isComplete);
	}
}
