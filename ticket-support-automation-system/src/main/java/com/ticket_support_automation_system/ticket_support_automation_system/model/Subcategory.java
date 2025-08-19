package com.ticket_support_automation_system.ticket_support_automation_system.model;

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
@Table(name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String subcategoryId;

    private String subcategoryName;

    //many subcategory -> one category
    @ManyToOne
    @JoinColumn(name = "category_id")
//    @JsonManagedReference
    private Category category;

    //one subcategory -> many tickets
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();
}
