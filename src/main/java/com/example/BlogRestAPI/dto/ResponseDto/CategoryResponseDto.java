package com.example.BlogRestAPI.dto.ResponseDto;

public class CategoryResponseDto {
    Integer id;
    String name;
    String desc;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public CategoryResponseDto(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    public CategoryResponseDto() {
    }
}
