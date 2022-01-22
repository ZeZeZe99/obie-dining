package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer calories;

    @Column(precision = 5, scale = 2) // 5 digits, 2 to the right of the decimal point
    private BigDecimal price;

//    @ManyToMany
//    @JoinTable(
//            name = "dish_preference",
//            joinColumns = @JoinColumn(name = "dish_id"),
//            inverseJoinColumns = @JoinColumn(name = "preference_id")
//    )
//    @JsonManagedReference
//    private List<Preference> preferences;

    // create a unidirectional many-to-one relationship to Bar
//    @ManyToOne(targetEntity = Bar.class, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Bar bar;

    public Dish(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Dish() {

    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Dish )) return false;
        return id != null && id.equals(((Dish) o).getId());
    }

    @Override
    public int hashCode(){
        return id;
    }



}
