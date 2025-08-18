package com.ticket_support_automation_system.ticket_support_automation_system.controller;

import com.ticket_support_automation_system.ticket_support_automation_system.model.User;
import com.ticket_support_automation_system.ticket_support_automation_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.GetAllUsers();
        return ResponseEntity.ok(users);

    }

    // add users from postman
    @PostMapping("/addUsers")
    public ResponseEntity<List<User>>  addUsers( @Valid @RequestBody List<User> user) {

        try {
            if (user.isEmpty()) {
                return ResponseEntity.noContent().build();

            }
            List<User> saveAllUsers = userService.SaveAllUsers(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(saveAllUsers);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
