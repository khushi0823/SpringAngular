package com.abhinandre.studentsystem.service;

import com.abhinandre.studentsystem.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    ResponseEntity<Student> getStudentById(int id);
    ResponseEntity<Student> updateStudent(int id, Student studentDetails);

    Map<String, Boolean> deleteStudent(int id);
}
