package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Group;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    // get all the group
    public List<Group> GetAllGroup() {
        return groupRepository.findAll();
    }

    // add data by postman
    // group related to category
    public List<Group> AddGroups(List<Group> group) {
        for (Group group1 : group) {
            if (group1.getCategories() != null){
                group1.getCategories().forEach(category -> {
                    category.setGroup(group1);
                    if(category.getSubcategories() != null){
                        category.getSubcategories().forEach(subcategory -> {
                            subcategory.setCategory(category);
                        });
                    }
                });


            }
        }
        return groupRepository.saveAll(group);
    }

    //
}
