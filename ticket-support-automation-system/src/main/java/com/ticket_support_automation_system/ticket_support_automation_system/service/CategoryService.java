package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Category;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // get all the category
    public List<Category> GetAllCategories() {
        return categoryRepository.findAll();
    }

    // add category
    public List<Category> AddCategories(List<Category> category) {
        for (Category c : category) {
            if (c.getSubcategories() != null) {
                c.getSubcategories().forEach(subc -> subc.setCategory(category));
            }
        }
    }
}
