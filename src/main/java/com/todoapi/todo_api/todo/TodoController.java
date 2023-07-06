package com.todoapi.todo_api.todo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TodoController {
	private final AtomicLong counter = new AtomicLong();

	ArrayList<Todo> todos = new ArrayList<Todo>(
		Arrays.asList(
			new Todo(
				counter.incrementAndGet(),
				"Create a todo",
				false
			),
			new Todo(
				counter.incrementAndGet(),
				"Update a todo",
				false
			),
			new Todo(
				counter.incrementAndGet(),
				"Delete a todo",
				false
			)
		)
	);


	@GetMapping("/")
	public ArrayList<Todo> getTodos() {
		return todos;
	}

	@PostMapping(value="/")
	public ArrayList<Todo> addTodo(@RequestBody String task) {

		// Get request body and remove task= and + from the string
		String taskTrimmed = task.substring(5).replace("+", " ");
		
		todos.add(new Todo(counter.incrementAndGet(), taskTrimmed, false));
		
		return todos;
	}

	@PutMapping(
		value="/",
		consumes={"application/json", "application/xml"},
		produces={"application/json", "application/xml"}
		)
	public ArrayList<Todo> updateTodo(
		@RequestBody Todo updatedTodo
	) {

		for (Todo todo : todos) {
			if (todo.getId() == updatedTodo.getId()) {
				todo.setTask(updatedTodo.getTask());
				todo.setIsComplete(updatedTodo.getIsComplete());
			}
		}
		return todos;
	}

	@DeleteMapping(
		value="/",
		consumes={"application/json", "application/xml"},
		produces={"application/json", "application/xml"}
		)
	public ArrayList<Todo> deleteTodo(
		@RequestBody long id
	) {
		
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				todos.remove(todo);
			}
		}
		return todos;
	}
	
}
