package com.example.CacheExample.Controller;

import com.example.CacheExample.Entities.Student;
import com.example.CacheExample.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController{

    @Autowired
    private StudentService studentService;

    @GetMapping("getStudents")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
