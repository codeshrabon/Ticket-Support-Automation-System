package com.ticket_support_automation_system.ticket_support_automation_system.controller;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Groups.Group;
import com.ticket_support_automation_system.ticket_support_automation_system.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    // get all the group
    @GetMapping("/allgroups")
    public ResponseEntity<List<Group>> getAllGroup() {
        List<Group> allgroup = groupService.GetAllGroup();
        return ResponseEntity.ok(allgroup);
    }

    // add group
    @PostMapping("/addgroups")
    public ResponseEntity<List<Group>> AddGroup(@RequestBody List<Group> group) {
        List<Group> saveGroup = groupService.AddGroups(group);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveGroup);
    }
}
