package com.example.BlogRestAPI.service;

import com.example.BlogRestAPI.dto.RequestDto.CategoryRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.CategoryResponseDto;

public interface CategoryService {
    public CategoryResponseDto createCategory(CategoryRequestDto category);
    public CategoryResponseDto getCategoryById(Integer id);
    public void deleteCategory(Integer id);
    public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto category);
    
}
