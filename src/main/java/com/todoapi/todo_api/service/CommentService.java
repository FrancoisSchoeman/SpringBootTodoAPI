package com.todoapi.todo_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.todoapi.todo_api.model.Comment;
import com.todoapi.todo_api.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public List<Comment> findAllComments(){
        return repository.findAll();
    }

    public Comment findCommentById(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found."));
    }

    public void createComment(Integer todoId, String commentText){
        Comment comment = new Comment(null, todoId, commentText, LocalDateTime.now(), null);
        repository.save(comment);
    }

    public Boolean commentExistsById(Integer id){
        return repository.existsById(id);
    }

    public void updateComment(Comment comment){
        repository.save(comment);
    }

    public void deleteCommentById(Integer id){
        repository.deleteById(id);
    }
}
