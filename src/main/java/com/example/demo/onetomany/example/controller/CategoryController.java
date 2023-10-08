package com.example.demo.onetomany.example.controller;

import com.example.demo.onetomany.example.entity.Category;
import com.example.demo.onetomany.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> allCategory(){
        return categoryService.allCategory();
    }
}
