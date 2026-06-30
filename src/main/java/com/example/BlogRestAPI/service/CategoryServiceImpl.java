package com.example.BlogRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogRestAPI.dto.RequestDto.CategoryRequestDto;
import com.example.BlogRestAPI.dto.ResponseDto.CategoryResponseDto;
import com.example.BlogRestAPI.entity.Category;
import com.example.BlogRestAPI.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryResponseDto EntityToDtoMapper(Category c){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(c.getId());
        categoryResponseDto.setName(c.getName());
        categoryResponseDto.setDesc(c.getDesc());
        return categoryResponseDto;
    }
    private Category DtoToEntityMapper(CategoryRequestDto c){
        Category category = new Category();
        category.setName(c.getName());
        category.setDesc(c.getDesc());
        return category;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto){
        Category category = DtoToEntityMapper(categoryRequestDto);
        Category savedCategory = categoryRepository.save(category);
        return EntityToDtoMapper(savedCategory);
    }
    @Override
    public CategoryResponseDto getCategoryById(Integer id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return EntityToDtoMapper(category);
    }
    @Override
    public CategoryResponseDto updateCategory(Integer id, CategoryRequestDto categoryRequestDto){
        Category category = categoryRepository.findById(id).orElse(new Category());
        category.setName(categoryRequestDto.getName());
        category.setDesc(categoryRequestDto.getDesc());
        Category updatedCategory = categoryRepository.save(category);
        return EntityToDtoMapper(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer id){
            Category category = categoryRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Category not found"));
            categoryRepository.delete(category);
    }
}
