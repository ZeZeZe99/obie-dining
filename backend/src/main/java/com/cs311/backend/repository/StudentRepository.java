package com.cs311.backend.repository;

import com.cs311.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // set this interface as a repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUserName(String username);

    Student getByUserNameAndPassword(String username,String password);

}