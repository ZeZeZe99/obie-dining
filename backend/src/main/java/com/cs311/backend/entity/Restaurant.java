package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    private Integer resId;

    private String resName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Bar.class, mappedBy = "restaurant")
    private List<Bar> bars;


}
