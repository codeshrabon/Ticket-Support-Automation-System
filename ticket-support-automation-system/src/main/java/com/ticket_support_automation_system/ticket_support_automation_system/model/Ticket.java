package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketPriority;
import com.ticket_support_automation_system.ticket_support_automation_system.model.enums.TicketEnums.TicketStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
@EntityListeners(AuditingEntityListener.class)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ticket ID required")
    @Column(nullable = false, unique = true)
    private String ticketId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private User ticketAssignedTo;


    @NotBlank(message = "Ticket title is required")
    private String ticketTitle;


    @NotNull(message = "Ticket priority is required")
    @Enumerated(EnumType.STRING)
    private TicketPriority ticketPriority;

    @NotNull(message = "Ticket status is required")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    @NotNull(message = "Group is required")
    private Group group;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"tickets", "subcategories"})
    @NotNull(message = "Category is required")
    private Category category;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subcategory_id")
    @JsonIgnoreProperties("tickets")
    @NotNull(message = "Subcategory is required")
    private Subcategory subcategory;

    private String ticketDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @CreatedDate
    private LocalDateTime ticketCreatedAt;
    @LastModifiedDate
    private LocalDateTime ticketModifiedAt;

    //one ticket -> many comments
    // orphanRemoval = true -> Otherwise, if a comment is removed from the list, it won’t automatically be deleted from DB.
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TicketComments> comments = new ArrayList<>();

    // one ticket -> many attachments
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TicketAttachment> attachments = new ArrayList<>();

}
