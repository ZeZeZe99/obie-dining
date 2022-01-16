package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(precision = 2, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Dish dish;

}
