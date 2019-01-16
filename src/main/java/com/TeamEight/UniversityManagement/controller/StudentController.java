package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.StudentDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public StudentDTO add(@RequestBody StudentDTO studentDTO){
        Student student=new Student();
        BeanUtils.copyProperties(studentDTO,student);
        Department department=departmentService.select(studentDTO.getDepartment());
        student.setDepartment(department);

        Student studentCreated=studentService.add(student);
        StudentDTO studentDTOCreated=new StudentDTO();
        BeanUtils.copyProperties(studentCreated,studentDTOCreated);
        studentDTOCreated.setDepartment(studentCreated.getDepartment().getDepartmentId());

        return studentDTOCreated;
    }

    @GetMapping("/select/{studentId}")
    public StudentDTO select(@PathVariable String studentId){
        Student student = studentService.select(studentId);
        StudentDTO studentDTO=new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        studentDTO.setDepartment(student.getDepartment().getDepartmentId());
        return studentDTO;
    }

    @GetMapping("/cgpa/{studentId}")
    public double cgpa(@PathVariable String studentId){
        double studentCGPA=studentService.getCGPA(studentId);
        return studentCGPA;
    }

    @GetMapping("/sgpa/{studentId}/{semester}")
    public double sgpa(@PathVariable String studentId,@PathVariable int semester){
        double studentSGPA=studentService.getSGPA(studentId,semester);
        return studentSGPA;
    }
}
