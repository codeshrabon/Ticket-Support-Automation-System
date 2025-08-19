package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Category;
import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Subcategory;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.CategoryRepository;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.SubcategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {


    private final SubcategoryRepository subcategoryRepository;


    private final CategoryRepository categoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }


    //get subcategory by categoryId
    public List<Subcategory> GetSubcategoryByCategory(Long categoryId) {
        return subcategoryRepository.findAll()
                .stream()
                .filter(sub -> sub.getCategory().getId().equals(categoryId))
                .toList();
    }

    public Subcategory AddSubcategoryToCategory(Long categoryId, Subcategory subcategory) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        subcategory.setCategory(category);

        return subcategoryRepository.save(subcategory);


    }
}
