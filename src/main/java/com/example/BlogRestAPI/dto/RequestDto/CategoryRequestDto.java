package com.example.BlogRestAPI.dto.RequestDto;

public class CategoryRequestDto {
    String name;
    String desc;
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
    public CategoryRequestDto(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public CategoryRequestDto() {
    }
}
