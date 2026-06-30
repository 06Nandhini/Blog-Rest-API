package com.example.BlogRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogRestAPI.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
}
