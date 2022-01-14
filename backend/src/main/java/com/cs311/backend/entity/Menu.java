package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    private Integer id;

    // unidirectional
    // one dish can be in many menus
    @ManyToOne(fetch = FetchType.EAGER)
    private Dish dish;

    // unidirectional
    // one bar can have many menus
    @ManyToOne(fetch = FetchType.EAGER)
    private Bar bar;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String slot;
}
