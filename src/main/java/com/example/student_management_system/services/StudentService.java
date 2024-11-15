package com.example.student_management_system.services;

import com.example.student_management_system.entities.StudentEntity;
import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<StudentModel> getStudentDetails() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities.stream().map(studentEntity -> new StudentModel(studentEntity.getStudentId(), studentEntity.getStudentName(), studentEntity.getEmail(), studentEntity.getPhone()))
                .toList();
    }
}
