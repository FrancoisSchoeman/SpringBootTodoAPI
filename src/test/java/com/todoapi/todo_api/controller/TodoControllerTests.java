package com.todoapi.todo_api.controller;

import com.todoapi.todo_api.model.Todo;
import com.todoapi.todo_api.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoControllerTests {

	@Autowired
	TodoService todoService;

	@BeforeEach
	void setup() {
		Todo todo = new Todo();
		todo.setTask("test");
		todoService.createTodo(todo);
	}

	@Test
	void findTodoTest() {
		Todo todo = todoService.findTodoById(1);
		Assertions.assertEquals("test", todo.getTask());
	}

	@Test
	void testCreateTodo() {
		Todo todo = new Todo();
		todo.setTask("test2");
		Todo resultTodo = todoService.createTodo(todo);

		Assertions.assertEquals("test2", resultTodo.getTask());
	}

}
