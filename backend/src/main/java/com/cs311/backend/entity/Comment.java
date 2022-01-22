package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 300)
    private String content;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Dish dish;

    private Integer upVote;

    private Integer downVote;


}
