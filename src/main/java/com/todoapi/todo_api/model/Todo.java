package com.todoapi.todo_api.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Todo {
    @Id
    private Integer id;

    @NotBlank
    private String task;

    private Boolean isComplete;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    public Todo() {}

    public Todo(Integer id, String task, Boolean isComplete, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.task = task;
        this.isComplete = isComplete;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    
}