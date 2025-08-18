package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketPriority;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
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
    private String ticketModifiedBy;

    @CreatedDate
    private LocalDateTime ticketCreatedAt;
    @LastModifiedDate
    private LocalDateTime ticketModifiedAt;

    //one ticket -> many comments
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketComments> comments = new ArrayList<>();


}
