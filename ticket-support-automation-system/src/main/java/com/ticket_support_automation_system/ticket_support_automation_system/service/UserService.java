package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.User;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // repo from userRepo
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all users
    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }




    // add users from postman
    public List<User> SaveAllUsers(List<User> user) {
        return userRepository.saveAll(user);
    }
}
