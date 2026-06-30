package com.example.BlogRestAPI.service;

import java.util.List;

import com.example.BlogRestAPI.dto.RequestDto.PostRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.PostResponseDto;

public interface PostService{
    PostResponseDto createPost(PostRequestDto post);
    List<PostResponseDto> getAllposts();
    PostResponseDto getPostById(Long id);
    PostResponseDto updatePost(Long id, PostRequestDto post);
    void deletePost(Long id);
}