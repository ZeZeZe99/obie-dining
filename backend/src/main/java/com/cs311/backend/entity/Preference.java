package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Preference {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Dish dish;
}
