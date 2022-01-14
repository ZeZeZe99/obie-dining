package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
