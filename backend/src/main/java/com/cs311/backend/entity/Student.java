package com.cs311.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String email;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "t_number")
    private String tNumber;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return userName;
//    }
//
//    public void setUsername(String username) {
//        this.userName = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
