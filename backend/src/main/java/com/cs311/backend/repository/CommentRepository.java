package com.cs311.backend.repository;

import com.cs311.backend.entity.Comment;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByDish(Dish dish);

    List<Comment> findCommentsByStudent(Student student);

    List<Comment> findCommentsByDishAndStudentAndContent(Dish dish, Student student, String content);


}
