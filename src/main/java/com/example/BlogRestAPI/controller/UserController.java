package com.example.BlogRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogRestAPI.dto.RequestDto.UserRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.UserResponseDto;
import com.example.BlogRestAPI.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@RequestParam Integer id){
        return ResponseEntity.ok(userService.getuserbyid(id));
    }
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user){
        return ResponseEntity.ok(userService.createuser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@RequestParam Integer id, @RequestBody UserRequestDto user){
        return ResponseEntity.ok(userService.updateuser(id, user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer id){
        userService.deleteuser(id);
        return ResponseEntity.noContent().build();
    }
    
}
