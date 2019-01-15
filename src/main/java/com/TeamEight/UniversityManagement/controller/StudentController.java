package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.StudentDTO;
import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.helper.DTOConvertor;
import com.TeamEight.UniversityManagement.helper.EntityConvertor;
import com.TeamEight.UniversityManagement.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public StudentDTO add(@RequestBody StudentDTO studentDTO){
        Student student=DTOConvertor.toStudentEntity(studentDTO);
        Student studentCreated=studentService.add(student);
        return EntityConvertor.toStudentDTO(studentCreated);
    }

    @GetMapping("/select/{studentId}")
    public StudentDTO select(@PathVariable String studentId){
        Student student = studentService.select(studentId);
        StudentDTO studentDTO = EntityConvertor.toStudentDTO(student);
        return studentDTO;
    }
}
