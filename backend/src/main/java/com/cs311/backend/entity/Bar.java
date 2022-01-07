package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
//@Table(name="bar")
public class Bar {
    @Id
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "resId")
    private Restaurant restaurant;

    @OneToMany(targetEntity = Dish.class, fetch = FetchType.LAZY, mappedBy = "bar")
    private List<Dish> dishes;

}
