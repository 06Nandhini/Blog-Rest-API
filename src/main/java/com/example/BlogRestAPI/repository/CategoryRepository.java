package com.example.BlogRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogRestAPI.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
