package com.TeamEight.UniversityManagement.helper;

import com.TeamEight.UniversityManagement.dto.*;
import com.TeamEight.UniversityManagement.entity.*;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityConvertor {
    @Autowired
    static DepartmentService departmentService;
    @Autowired
    static ProfessorService professorService;

    public static DepartmentDTO toDepartmentDTO(Department department)
    {
        DepartmentDTO departmentDTO=new DepartmentDTO();
        BeanUtils.copyProperties(department,departmentDTO);
        departmentDTO.setHeadOfDepartment(department.getHeadOfDepartment().getProfessorId());

        return departmentDTO;
    }

    public static StudentDTO toStudentDTO(Student student)
    {
        StudentDTO studentDTO=new StudentDTO();
        BeanUtils.copyProperties(student,studentDTO);
        studentDTO.setDepartment(student.getDepartment().getDepartmentId());

        return studentDTO;
    }

    public static ProfessorDTO toProfessorDTO(Professor professor)
    {
        ProfessorDTO professorDTO=new ProfessorDTO();
        BeanUtils.copyProperties(professor,professorDTO);
        professorDTO.setPrimaryDepartment(professor.getPrimaryDepartment().getDepartmentId());
        professorDTO.setSecondaryDepartment(professor.getSecondaryDepartment().getDepartmentId());

        return professorDTO;
    }

    public static RegistrationDTO toRegistrationDTO(Registration registration)
    {
        RegistrationDTO registrationDTO=new RegistrationDTO();
        BeanUtils.copyProperties(registration,registrationDTO);
        registrationDTO.setStudentId(registration.getStudentId().getStudentId());
        registrationDTO.setProfessorId(registration.getProfessorId().getProfessorId());
        registrationDTO.setSubjectId(registration.getSubjectId().getSubjectId());

        return registrationDTO;
    }

    public static SubjectDTO toSubjectDTO(Subject subject) {
        SubjectDTO subjectDTO=new SubjectDTO();
        BeanUtils.copyProperties(subject,subjectDTO);
        subjectDTO.setDepartment(subject.getDepartment().getDepartmentId());

        return subjectDTO;
    }
}
