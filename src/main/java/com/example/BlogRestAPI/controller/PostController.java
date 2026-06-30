package com.example.BlogRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogRestAPI.dto.RequestDto.PostRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.PostResponseDto;
import com.example.BlogRestAPI.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    @Autowired
    private PostService postservice;

    @PostMapping
    public ResponseEntity<PostResponseDto> create( @RequestBody PostRequestDto post){
        return ResponseEntity.ok(postservice.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAll(){

        return ResponseEntity.ok(
            postservice.getAllposts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getById( @PathVariable Long id){
        return ResponseEntity.ok(
            postservice.getPostById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable Long id, @RequestBody PostRequestDto p){
        return ResponseEntity.ok( 
            postservice.updatePost(id, p)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        postservice.deletePost(id);
        return ResponseEntity.ok( 
            "Deleted"
        );
    }
}
