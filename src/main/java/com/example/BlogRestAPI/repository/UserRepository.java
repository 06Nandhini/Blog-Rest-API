package com.example.BlogRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogRestAPI.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
