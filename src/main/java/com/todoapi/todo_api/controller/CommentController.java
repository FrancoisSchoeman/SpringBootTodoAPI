package com.todoapi.todo_api.controller;

import com.todoapi.todo_api.model.Comment;
import com.todoapi.todo_api.service.CommentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping(value="")
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }
    

	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createComment(@Valid @RequestBody Map<String, Object> request) {

        if(!request.containsKey("comment")){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Key 'comment' not supplied.");
        }

        if(!request.containsKey("todo-id")){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Key 'comment' not supplied.");
        }

        String commentText = (String) request.get("comment");

        Integer todoId = (Integer) request.get("todo-id");

        service.createComment(todoId, commentText);
    }
}