package com.cs311.backend.service;

import com.cs311.backend.entity.Comment;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Student;
import com.cs311.backend.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    // create a new comment
    @Transactional
    public void newComment(Comment comment){
        List<Comment> existedComment = commentRepository.findCommentsByDishAndStudentAndContent
                (comment.getDish(), comment.getStudent(), comment.getContent());
        if (existedComment == null || existedComment.size() == 0) {
            commentRepository.save(comment);
        }
    }
}
