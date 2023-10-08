package com.example.demo.onetomany.example.service;

import com.example.demo.onetomany.example.entity.Category;
import com.example.demo.onetomany.example.respository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> allCategory() {
        return categoryRespository.findAll();
    }

    public Category getCategory(int id) {
        return categoryRespository.findById(id).get();
    }

}

