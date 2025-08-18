package com.ticket_support_automation_system.ticket_support_automation_system.repository;

import com.ticket_support_automation_system.ticket_support_automation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
