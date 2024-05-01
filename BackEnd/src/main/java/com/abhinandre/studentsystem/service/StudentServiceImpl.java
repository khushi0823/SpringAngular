package com.abhinandre.studentsystem.service;

import com.abhinandre.studentsystem.model.Student;
import com.abhinandre.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> getStudentById(int id){
        Student student = studentRepository.findByid(id);
        if(student != null){
            return  ResponseEntity.ok(student);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<Student> updateStudent(int id,Student studentDetails){
        Student student = studentRepository.findByid(id);

        student.setName(studentDetails.getName());
        student.setAddress(studentDetails.getAddress());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @Override
    public Map<String, Boolean> deleteStudent(int id)  {
        Student student = studentRepository.findByid(id);
        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
