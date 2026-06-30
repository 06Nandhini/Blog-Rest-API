package com.example.BlogRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogRestAPI.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
}
