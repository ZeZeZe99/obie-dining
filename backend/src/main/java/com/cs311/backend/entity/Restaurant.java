/* The entity class for restaurant */
package com.cs311.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data // it tells spring to automatically generate getter and setter functions for every field
@Entity // this sets the class as an entity
// indicates that this entity corresponds to a table in the database
// each instance of the class corresponds to a row in the table
// @name: name of the table
@Table(name = "restaurant")
public class Restaurant {
    @Id // must specify a unique field for the class
    @GeneratedValue // can automatically generate this field when creating a new instance
    private Integer id;

    // represent other columns in the table, must be the same as column names
    private String name;

    // specify the relationship to another entity
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Bar.class, mappedBy = "restaurant")
    @JsonManagedReference // forward of the reference, to be serialized
    private List<Bar> bars;


}
