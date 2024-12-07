package com.delogic.tickets.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_group")
    private String group;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;
}
