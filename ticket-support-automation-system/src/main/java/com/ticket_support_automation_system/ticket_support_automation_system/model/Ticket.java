package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketPriority;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketId;
    private String ticketAssignedTo;
    private String ticketTitle;


    @Enumerated(EnumType.STRING)
    private TicketPriority ticketPriority;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    private String ticketDescription;
    private String ticketCreatedBy;
    private String ticketCreatedAt;
    private String ticketModifiedBy;
    private String ticketModifiedAt;

    //one ticket -> many comments
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketComments> comments = new ArrayList<>();


}
