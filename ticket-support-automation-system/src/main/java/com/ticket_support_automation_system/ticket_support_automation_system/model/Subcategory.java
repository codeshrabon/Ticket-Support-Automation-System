package com.ticket_support_automation_system.ticket_support_automation_system.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subcategoryId;
    private String subcategoryName;

    //many subcategory -> one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //one subcategory -> many tickets
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
