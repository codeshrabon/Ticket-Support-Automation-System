package com.ticket_support_automation_system.ticket_support_automation_system.repository;

import com.ticket_support_automation_system.ticket_support_automation_system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
