package com.example.CacheExample.Service;

import com.example.CacheExample.Entities.Student;
import com.example.CacheExample.Repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Cacheable(value = "students")
    public List<Student> getAllStudents(){
        logger.info("Going to fetch the data from the DB");
        List<Student> students = repository.findAll();
        logger.info("Retrieved {} from database",students.size());
        return students;
    }

    @CacheEvict(value = "students",allEntries = true)
    public Student addStudent(Student student){
        logger.info("Adding new student: rollno={}, age={}, sex={}",
                student.getRollNo(), student.getAge(), student.getSex());
        Student savedStudent = repository.save(student);
        logger.info("Student saved Successfully with rollNo:{}",savedStudent.getRollNo());
        return savedStudent;
    }
}
