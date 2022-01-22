package com.cs311.backend.controller;

import com.cs311.backend.entity.Student;
import com.cs311.backend.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService)
    { this.studentService = studentService; }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody Student requestUser) {
        String username = requestUser.getUsername();
        //username = HtmlUtils.htmlEscape(username);

//        try{
//            //Student user = studentService.get(username, requestUser.getPassword());
//            return ResponseEntity.ok("Yeah");
//        } catch (Exception x) {
//            return ResponseEntity.badRequest().body("Wrong password or username");
//        }
        Student user = studentService.get(username, requestUser.getPassword());
        if (null == user) {
            return ResponseEntity.badRequest().body("Wrong password or username");
        } else {
            return ResponseEntity.ok("Yeah");
        }
    }
}
