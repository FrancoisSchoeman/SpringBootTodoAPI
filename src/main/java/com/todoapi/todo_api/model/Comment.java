package com.todoapi.todo_api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;

@Entity
public class Comment {
    @Id
    private Integer id;

    private Integer todoId;

    @NotBlank
    private String comment;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    public Comment() {}

    public Comment(Integer id, Integer todoId, String comment, LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.todoId = todoId;
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setIsComplete(Integer todoId) {
        this.todoId = todoId;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
