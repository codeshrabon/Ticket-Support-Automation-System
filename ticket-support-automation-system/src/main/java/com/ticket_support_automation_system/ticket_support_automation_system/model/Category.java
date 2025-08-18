package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryId;
    private String categoryName;

    //one category -> one group
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    //one category -> many subcategories
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Subcategory> subcategories;
}
