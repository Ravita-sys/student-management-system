package com.example.student_management_system.services;

import com.example.student_management_system.entities.StudentEntity;
import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<?> saveStudentDetails(StudentModel studentModel) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentModel.getStudentName());
        studentEntity.setEmail(studentModel.getEmail());
        studentEntity.setPhone(studentModel.getPhone());
        studentRepository.save(studentEntity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
