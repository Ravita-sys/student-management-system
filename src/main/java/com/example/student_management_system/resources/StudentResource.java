package com.example.student_management_system.resources;

import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std")
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudentDetails")
    public ResponseEntity<?> saveStudentDetails(@RequestBody StudentModel studentModel){
        return studentService.saveStudentDetails(studentModel);
    }
    @GetMapping("/getStudentDetails")
    public List<StudentModel> getStudentDetails(){
        return studentService.getStudentDetails();
    }
}
