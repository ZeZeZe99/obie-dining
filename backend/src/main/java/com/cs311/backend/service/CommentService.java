package com.cs311.backend.service;

import com.cs311.backend.entity.Comment;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Student;
import com.cs311.backend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> findCommentsByDish(Dish dish){
        return commentRepository.findCommentsByDish(dish);
    }

    public List<Comment> findCommentsByStudent(Student student){
        return commentRepository.findCommentsByStudent(student);
    }
}
