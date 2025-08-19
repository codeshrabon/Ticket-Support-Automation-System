package com.ticket_support_automation_system.ticket_support_automation_system.repository;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory,Long> {

}
