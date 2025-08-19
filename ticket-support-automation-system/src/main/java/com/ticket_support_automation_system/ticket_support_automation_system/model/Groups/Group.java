package com.ticket_support_automation_system.ticket_support_automation_system.model.Groups;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ticket_support_automation_system.ticket_support_automation_system.model.Ticket;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_group")

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String groupId;
    private String groupName;

    // Ticket already knows which Category it belongs to
    //Tickets belong to Category (or Subcategory), not directly to Group
    /*// one group -> many ticket
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();*/

    //one group -> many category
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Category> categories;

}
