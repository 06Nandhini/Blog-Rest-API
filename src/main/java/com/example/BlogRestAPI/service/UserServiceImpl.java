package com.example.BlogRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogRestAPI.dto.RequestDto.UserRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.UserResponseDto;
import com.example.BlogRestAPI.entity.User;
import com.example.BlogRestAPI.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private UserResponseDto mapToUserResponseDto(User user) {
        // Mapping logic from User entity to UserResponseDto
        return new UserResponseDto(user.getName(), user.getEmail(), user.getRole());
    }

    private User UserRequestDtoToUser(UserRequestDto userRequestDto) {
        // Mapping logic from UserRequestDto to User entity
        User user = new User();
        user.setName(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());
        user.setRole(userRequestDto.getRole());
        return user;
    }
    @Override
    public UserResponseDto createuser(UserRequestDto user) {
        // Implementation for creating a user
        User userEntity = userRepository.save(UserRequestDtoToUser(user));
        return mapToUserResponseDto(userEntity);
    }
    @Override
    public UserResponseDto getuserbyid(Integer id) {
        // Implementation for retrieving a user by ID
        User userEntity = userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
        return mapToUserResponseDto(userEntity);
    }
    @Override
    public void deleteuser(Integer id){
        userRepository.deleteById(id);
    }
    @Override
    public UserResponseDto updateuser(Integer id, UserRequestDto user){
        User existingUser=userRepository.findById(id).orElse(new User());
        existingUser.setName(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        User updatedUser=userRepository.save(existingUser);
        return mapToUserResponseDto(updatedUser);
    }
}
