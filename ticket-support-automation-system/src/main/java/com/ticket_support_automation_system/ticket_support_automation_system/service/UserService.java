package com.ticket_support_automation_system.ticket_support_automation_system.service;

import com.ticket_support_automation_system.ticket_support_automation_system.model.User;
import com.ticket_support_automation_system.ticket_support_automation_system.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public User FindById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID: " + id +" not found"));
    }

    // update user by ID
    public User UpdateUser(Long id, @Valid User user) {
        return userRepository.findById(id)
                .map(existinguser -> {
                    existinguser.setUserId(user.getUserId());
                    existinguser.setUserName(user.getUserName());
                    existinguser.setUserDateOfBirth(user.getUserDateOfBirth());
                    existinguser.setUserPhone(user.getUserPhone());
                    existinguser.setUserEmail(user.getUserEmail());
                    existinguser.setUserPassword(user.getUserPassword());
                    existinguser.setUserRole(user.getUserRole());
                    existinguser.setUserDepartment(user.getUserDepartment());
                    existinguser.setUserJobTitle(user.getUserJobTitle());
                    existinguser.setUserDateOfJoining(user.getUserDateOfJoining());
                    existinguser.setUserPresentAddress(user.getUserPresentAddress());
                    existinguser.setUserPermanentAddress(user.getUserPermanentAddress());
                    existinguser.setUserEmergencyContactName(user.getUserEmergencyContactName());
                    existinguser.setUserEmergencyContactPhone(user.getUserEmergencyContactPhone());
                    existinguser.setUserCreatedAt(existinguser.getUserCreatedAt());
                    existinguser.setUserCreatedBy(user.getUserCreatedBy());
                    existinguser.setUserUpdatedAt(existinguser.getUserUpdatedAt());
                    existinguser.setUserUpdatedBy(existinguser.getUserUpdatedBy());

                    return userRepository.save(existinguser);
                })
                .orElseThrow(() -> new RuntimeException("User ID: " +id + " not found"));


    }


    // delete user by id
    public void DeleteById(Long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }
}
