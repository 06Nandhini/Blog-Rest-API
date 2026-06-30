package com.example.BlogRestAPI.service;

import com.example.BlogRestAPI.dto.RequestDto.CommentRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.CommentResponseDto;

public interface CommentService {
    public CommentResponseDto createComment(CommentRequestDto comment);
    public CommentResponseDto getCommentById(Integer id);
    public void deleteComment(Integer id);
    public CommentResponseDto updateComment(Integer id, CommentRequestDto comment);
    
}
