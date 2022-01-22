package com.cs311.backend.service;

import com.cs311.backend.entity.Student;
import org.springframework.stereotype.Service;
import com.cs311.backend.repository.StudentRepository;

import java.util.List;

@Service // set this class as a service class
public class StudentService {

    // use its repository
    private final StudentRepository StudentRepository;

    public StudentService(StudentRepository StudentRepository){
        this.StudentRepository = StudentRepository;
    }

    public boolean isExist(String username) {
        Student user = getByName(username);
        return null!=user;
    }

    public Student getByName(String username) {
        return StudentRepository.findByUserName(username);
    }

    public Student get(String username, String password){
        return StudentRepository.getByUserNameAndPassword(username, password);
    }

    public void add(Student user) {
        StudentRepository.save(user);
    }
}