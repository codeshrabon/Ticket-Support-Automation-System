package com.ticket_support_automation_system.ticket_support_automation_system.controller;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Category;
import com.ticket_support_automation_system.ticket_support_automation_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get all the category
    @GetMapping("/allcategory")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategory = categoryService.GetAllCategories();
        return ResponseEntity.ok(allCategory);
    }

    // add category from postman
    @PostMapping("/addcategory")
    public ResponseEntity<List<Category>> AddCategory(@RequestBody List<Category> category) {
        List<Category> saveCategories = categoryService.AddCategories(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCategories);

    }
}
