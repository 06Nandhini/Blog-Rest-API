package com.example.BlogRestAPI.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String Message;

    @Column(nullable = false)
    private Integer user_id;

    @UpdateTimestamp
    private LocalDateTime update;

    @CreationTimestamp
    private LocalDateTime create;
}
