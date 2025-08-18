package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_history")
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketHistoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ticket_id",  nullable = false)
    private Ticket ticket;

    private String fieldName;
    private String oldValue;
    private String newValue;
    private String changedAt;
}
