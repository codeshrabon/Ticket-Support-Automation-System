package com.ticket_support_automation_system.ticket_support_automation_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryId;
    private String categoryName;

    //one category -> one group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonBackReference
    private List<Ticket> tickets = new ArrayList<>();

    //one category -> many subcategories
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Subcategory> subcategories;
}
