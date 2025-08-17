package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_comments")
public class TicketComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many comments -> one ticket
    @ManyToOne
    @JoinColumn(name = "ticket_id",  nullable = false)
    private Ticket ticket;

    //many comments -> one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
