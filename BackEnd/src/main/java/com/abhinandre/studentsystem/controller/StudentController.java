package com.abhinandre.studentsystem.controller;

import com.abhinandre.studentsystem.model.Student;
import com.abhinandre.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student add(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.getAllStudents();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student studentDetails){
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id) {
        Map<String, Boolean> response = studentService.deleteStudent(id);
        return ResponseEntity.ok(response);
    }




}
