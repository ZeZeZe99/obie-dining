package com.cs311.backend.service;

import com.cs311.backend.entity.Student;
import org.springframework.stereotype.Service;
import com.cs311.backend.repository.StudentRepository;
import org.springframework.web.util.HtmlUtils;

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

    public int register(Student user) {
        String username = user.getUserName();
        String email = user.getEmail();
        String password = user.getPassword();
        String tnum = user.getTNumber();

        username = HtmlUtils.htmlEscape(username);
        user.setUserName(username);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        tnum = HtmlUtils.htmlEscape(tnum);
        user.setTNumber(tnum);

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        int times = 2;
//        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
//
//        user.setSalt(salt);
//        user.setPassword(encodedPassword);
        user.setPassword(password);

        StudentRepository.save(user);

        return 1;
    }

//    public void updateUserStatus(Student user) {
//        Student userInDB = StudentRepository.findByUsername(user.getUsername());
//        userInDB.setEnabled(user.isEnabled());
//        StudentRepository.save(userInDB);
//    }
//
//    public Student resetPassword(Student user) {
//        Student userInDB = StudentRepository.findByUsername(user.getUsername());
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        int times = 2;
//        userInDB.setSalt(salt);
//        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
//        userInDB.setPassword(encodedPassword);
//        return StudentRepository.save(userInDB);
//    }

    public void editUser(Student user) {
        Student userInDB = StudentRepository.findByUserName(user.getUserName());
        userInDB.setEmail(user.getEmail());
        StudentRepository.save(userInDB);
    }

    public void deleteById(int id) {
        StudentRepository.deleteById(id);
    }
}