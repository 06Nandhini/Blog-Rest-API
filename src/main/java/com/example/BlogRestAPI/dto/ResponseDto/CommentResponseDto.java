package com.example.BlogRestAPI.dto.ResponseDto;

public class CommentResponseDto {
    
    Integer comment_id;
    String message;
    Integer user_id;

    public Integer getComment_id() {
        return comment_id;
    }
    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public CommentResponseDto(Integer comment_id, String message, Integer user_id) {
        this.comment_id = comment_id;
        this.message = message;
        this.user_id = user_id;
    }
    public CommentResponseDto() {
    }
}
