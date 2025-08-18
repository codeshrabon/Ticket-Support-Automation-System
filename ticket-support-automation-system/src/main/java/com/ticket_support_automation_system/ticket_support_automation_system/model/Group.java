package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
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
