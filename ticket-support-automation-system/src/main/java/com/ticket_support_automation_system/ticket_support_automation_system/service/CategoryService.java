package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Category;
import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Group;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.CategoryRepository;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final GroupRepository groupRepository;

    public CategoryService(CategoryRepository categoryRepository, GroupRepository groupRepository) {
        this.categoryRepository = categoryRepository;
        this.groupRepository = groupRepository;
    }


    // get category by group
    public List<Category> GetCategoriesByGroup(Long groupdId) {
        return categoryRepository.findAll()
                .stream()
                .filter(c -> c.getGroup().getId().equals(groupdId))
                .toList();
    }

    // add category
    public Category AddCategoriesToGroup(Long groupId, Category category) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        category.setGroup(group);

        if (category.getSubcategories() != null) {
            category.getSubcategories().forEach(subcategory -> subcategory.setCategory(category));
        }
        return categoryRepository.save(category);
    }
}
