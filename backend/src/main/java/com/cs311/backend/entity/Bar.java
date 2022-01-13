package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="bar")
public class Bar {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference // back of reference, not serialized
    private Restaurant restaurant;

    @OneToMany(targetEntity = Dish.class, fetch = FetchType.LAZY, mappedBy = "bar")
    @JsonManagedReference
    private List<Dish> dishes;

}
