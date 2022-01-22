package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Allergen {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Dish dish;
}
