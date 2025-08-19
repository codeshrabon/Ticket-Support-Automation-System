package com.ticket_support_automation_system.ticket_support_automation_system.controller;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Subcategory;
import com.ticket_support_automation_system.ticket_support_automation_system.service.CategoryService;
import com.ticket_support_automation_system.ticket_support_automation_system.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubcategoryController {

    @Autowired
    private final SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }


    // get subcategory by categoryId
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Subcategory>> getSubcategoryByCategory(@PathVariable Long categoryId) {
        List<Subcategory> getSubcategory = subcategoryService.GetSubcategoryByCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(getSubcategory);
    }

    // add subcategory by category ID
    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Subcategory> addSubcategory(@PathVariable Long categoryId, @RequestBody Subcategory subcategory) {
        Subcategory saveSubcategory = subcategoryService.AddSubcategoryToCategory(categoryId,subcategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveSubcategory);
    }

}
