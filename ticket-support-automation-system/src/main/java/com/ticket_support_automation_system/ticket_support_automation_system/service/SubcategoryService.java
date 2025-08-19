package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {

    @Autowired
    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }
}
