package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(unique = true, nullable = false)
    private String groupId;
    private String groupName;

    //one group -> many category
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Category> categories;

}
