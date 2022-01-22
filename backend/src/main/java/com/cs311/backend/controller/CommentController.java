package com.cs311.backend.controller;

import com.cs311.backend.entity.Comment;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Student;
import com.cs311.backend.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @RequestMapping("/comment/findCommentsByDish")
    public List<Comment> findCommentsByDish(@RequestBody Dish dish){
        return commentService.findCommentsByDish(dish);
    }

    @RequestMapping("/comment/findCommentsByStudent")
    public List<Comment> findCommentsByStudent(@RequestBody Student student){
        return commentService.findCommentsByStudent(student);
    }
}
