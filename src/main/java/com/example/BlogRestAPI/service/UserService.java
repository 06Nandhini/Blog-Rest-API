package com.example.BlogRestAPI.service;

import com.example.BlogRestAPI.dto.RequestDto.UserRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.UserResponseDto;

public interface UserService {
    public UserResponseDto createuser(UserRequestDto user);
    public UserResponseDto getuserbyid(Integer id);
    public void deleteuser(Integer id);
    public UserResponseDto updateuser(Integer id, UserRequestDto user);
}
