package com.cs311.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String userName;

    private String password;
}
