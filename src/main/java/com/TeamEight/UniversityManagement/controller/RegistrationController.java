package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.RegistrationDTO;
import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.entity.Registration;
import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.entity.Subject;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import com.TeamEight.UniversityManagement.services.RegistrationService;
import com.TeamEight.UniversityManagement.services.StudentService;
import com.TeamEight.UniversityManagement.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/registration")
@RestController

public class RegistrationController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    StudentService studentService;
    @Autowired
    ProfessorService professorService;
    @Autowired
    SubjectService subjectService;

    @PostMapping("/add")
    public RegistrationDTO add(@RequestBody RegistrationDTO registrationDTO){

        Registration registration=new Registration();
        BeanUtils.copyProperties(registrationDTO,registration);
        Student student=studentService.select(registrationDTO.getStudentId());
        Professor professor=professorService.select(registrationDTO.getProfessorId());
        Subject subject=subjectService.select(registrationDTO.getSubjectId());
        registration.setStudentId(student);
        registration.setProfessorId(professor);
        registration.setSubjectId(subject);

        Registration registrationCreated = registrationService.add(registration);
        RegistrationDTO registrationDTOCreated=new RegistrationDTO();
        BeanUtils.copyProperties(registrationCreated,registrationDTOCreated);
        registrationDTOCreated.setStudentId(registrationCreated.getStudentId().getStudentId());
        registrationDTOCreated.setProfessorId(registrationCreated.getProfessorId().getProfessorId());
        registrationDTOCreated.setSubjectId(registrationCreated.getSubjectId().getSubjectId());

        return registrationDTOCreated;
    }

    @GetMapping("/select/{registrationId}")
    public RegistrationDTO select(@PathVariable String registrationId){
        Registration registration = registrationService.select(registrationId);
        RegistrationDTO registrationDTO=new RegistrationDTO();
        BeanUtils.copyProperties(registration,registrationDTO);
        registrationDTO.setStudentId(registration.getStudentId().getStudentId());
        registrationDTO.setProfessorId(registration.getProfessorId().getProfessorId());
        registrationDTO.setSubjectId(registration.getSubjectId().getSubjectId());
        return registrationDTO;
    }
}
