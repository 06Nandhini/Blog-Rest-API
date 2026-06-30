package com.example.BlogRestAPI.dto.RequestDto;

public class CommentRequestDto {
    
    String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public CommentRequestDto(String message) {
        this.message = message;
    }
    public CommentRequestDto() {
    }
}
