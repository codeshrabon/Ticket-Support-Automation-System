package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupId;
    private String groupName;

    //one group -> many category
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private List<Category> categories;

}
