package com.todoapi.todo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoApiApplication {
    public static void main(String[] args) {
      SpringApplication.run(TodoApiApplication.class, args);
    }
}