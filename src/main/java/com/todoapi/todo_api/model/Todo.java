package com.todoapi.todo_api.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

public record Todo(
    @Id
    Integer id,
    @NotBlank
    String task,
    Boolean isComplete,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated
) {
}