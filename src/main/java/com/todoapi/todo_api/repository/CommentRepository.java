package com.todoapi.todo_api.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.todoapi.todo_api.model.Comment;

public interface CommentRepository extends ListCrudRepository<Comment, Integer>{
        
}
