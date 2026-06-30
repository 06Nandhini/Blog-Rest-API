package com.example.BlogRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BlogRestAPI.dto.ResponseDto.CategoryResponseDto;
import com.example.BlogRestAPI.dto.RequestDto.CategoryRequestDto;
import com.example.BlogRestAPI.service.CategoryService;

@RequestMapping("/api/categories")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@RequestParam Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestParam CategoryRequestDto category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@RequestParam Integer id, @RequestParam CategoryRequestDto category){
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@RequestParam Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
     
}
