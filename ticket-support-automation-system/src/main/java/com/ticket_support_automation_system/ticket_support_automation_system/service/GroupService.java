package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


}
