package com.example.BlogRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogRestAPI.dto.RequestDto.CommentRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.CommentResponseDto;
import com.example.BlogRestAPI.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto comment){
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestParam Integer id, @RequestBody CommentRequestDto comment){
        return ResponseEntity.ok(commentService.updateComment(id, comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@RequestParam Integer id){    
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
    

}
