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
    @PostMapping("/postmanAddUsers")
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

    //find user by id
    @GetMapping("/findById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            System.out.print("User id: " + id);
            User userId = userService.FindById(id);

            return ResponseEntity.status(HttpStatus.FOUND).body(userId);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // update by id in existing data
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        try {
            System.out.print("User id: " + id +" ");

            User updateUser = userService.UpdateUser(id, user);
            return ResponseEntity.status(HttpStatus.CREATED).body(updateUser);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // delete by id
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

}
