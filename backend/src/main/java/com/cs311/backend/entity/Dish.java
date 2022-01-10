package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Bar.class, fetch = FetchType.LAZY)
    @JoinColumn
    private Bar bar;
}
