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

    // creating a bidirectional relationship between Bar and Restaurant
    // when a bar is loaded, its restaurant will be loaded as well
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JsonBackReference // back of reference, not serialized
    private Restaurant restaurant;


//    @OneToMany(targetEntity = Dish.class, fetch = FetchType.LAZY, mappedBy = "bar")
//    @JsonManagedReference
//    private List<Dish> dishes;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Bar )) return false;
        return id != null && id.equals(((Bar) o).getId());
    }

    @Override
    public int hashCode(){
        return id;
    }
}
