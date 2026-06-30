package com.example.BlogRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogRestAPI.dto.RequestDto.CommentRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.CommentResponseDto;
import com.example.BlogRestAPI.entity.Comment;
import com.example.BlogRestAPI.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    private CommentResponseDto EntityToResponse(Comment comment) {
        CommentResponseDto response = new CommentResponseDto();
        response.setUser_id(comment.getComment_id());
        response.setMessage(comment.getMessage());
        return response;   
    }
    private Comment RequestToEntity(CommentRequestDto comment) {
        Comment commentEntity = new Comment();
        commentEntity.setMessage(comment.getMessage());
        return commentEntity;
    }
    @Override
    public CommentResponseDto createComment(CommentRequestDto comment) {
        Comment commentEntity = RequestToEntity(comment);
        Comment savedComment = commentRepository.save(commentEntity);
        return EntityToResponse(savedComment);
    }
    @Override
    public CommentResponseDto getCommentById(Integer comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return EntityToResponse(comment);
    }
    @Override
    public CommentResponseDto updateComment(Integer comment_id, CommentRequestDto comment) {
        Comment existingComment = commentRepository.findById(comment_id).orElse(new Comment());
        existingComment.setMessage(comment.getMessage());
        Comment updatedComment = commentRepository.save(existingComment);
        return EntityToResponse(updatedComment);
    }
    @Override
    public void deleteComment(Integer comment_id) {
        Comment existingComment = commentRepository.findById(comment_id).orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(existingComment);
    }
    
}
