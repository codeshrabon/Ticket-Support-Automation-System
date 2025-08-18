package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_attachment")
public class TicketAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketAttachmentName;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String filePath;
    private String fileName;
    private String uploadedBy;
    private String createdAt;
    private String updatedAt;
    private String updatedBy;


}
