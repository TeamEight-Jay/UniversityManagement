package com.TeamEight.UniversityManagement.helper;

import com.TeamEight.UniversityManagement.dto.*;
import com.TeamEight.UniversityManagement.entity.*;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import com.TeamEight.UniversityManagement.services.StudentService;
import com.TeamEight.UniversityManagement.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DTOConvertor {

    @Autowired
    static DepartmentService departmentService;
    @Autowired
    static ProfessorService professorService;
    @Autowired
    static StudentService studentService;
    @Autowired
    static SubjectService subjectService;

    public static Department toDepartmentEntity(DepartmentDTO departmentDTO)
    {
        Department department=new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        return department;
    }

    public static Student toStudentEntity(StudentDTO studentDTO)
    {
        Student student=new Student();
        BeanUtils.copyProperties(studentDTO,student);
        Department department=departmentService.select(studentDTO.getDepartment());
        student.setDepartment(department);

        return student;
    }

    public static Professor toProfessorEntity(ProfessorDTO professorDTO)
    {
        Professor professor=new Professor();
        BeanUtils.copyProperties(professorDTO,professor);
        Department primaryDepartment=departmentService.select(professorDTO.getPrimaryDepartment());
        Department secondaryDepartment=departmentService.select(professorDTO.getSecondaryDepartment());
        professor.setPrimaryDepartment(primaryDepartment);
        professor.setSecondaryDepartment(secondaryDepartment);

        return professor;
    }

    public static Subject toSubjectEntity(SubjectDTO subjectDTO)
    {
        Subject subject=new Subject();
        BeanUtils.copyProperties(subjectDTO,subject);
        Department department=departmentService.select(subjectDTO.getDepartment());
        subject.setDepartment(department);

        return subject;
    }

    public static Registration toRegistrationEntity(RegistrationDTO registrationDTO)
    {
        Registration registration=new Registration();
        BeanUtils.copyProperties(registrationDTO,registration);
        Student student=studentService.select(registrationDTO.getStudentId());
        Professor professor=professorService.select(registrationDTO.getProfessorId());
        Subject subject=subjectService.select(registrationDTO.getSubjectId());
        registration.setStudentId(student);
        registration.setProfessorId(professor);
        registration.setSubjectId(subject);

        return registration;

    }

}
