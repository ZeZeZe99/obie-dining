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
    public ResponseEntity<Student> login(@RequestBody Student requestUser) {
        String username = requestUser.getUserName();
        username = HtmlUtils.htmlEscape(username);

        Student user = studentService.get(username, requestUser.getPassword());
        if (null == user) {
            return ResponseEntity.badRequest()
                    .header("errormessage", "Wrong username or password!")
                    .body(null);
        } else {
            return ResponseEntity.ok(user);
        }
    }
    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody Student user) {
        int status = studentService.register(user);
        switch (status) {
            case 1:
                return ResponseEntity.ok("Success");
            case 2:
                return ResponseEntity.badRequest().body("User already exist");
        }
        return ResponseEntity.badRequest().body("Unknown Error");
    }
}
