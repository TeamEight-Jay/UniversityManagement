package com.TeamEight.UniversityManagement.helper;

import com.TeamEight.UniversityManagement.dto.DepartmentDTO;
import com.TeamEight.UniversityManagement.dto.StudentDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DTOConvertor {

    @Autowired
    static DepartmentService departmentService;
    @Autowired
    static ProfessorService professorService;

    public static Department toDepartmentEntity(DepartmentDTO departmentDTO)
    {
        Department department=new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        Professor headOfDepartment=professorService.select(departmentDTO.getHeadOfDepartment());
        department.setHeadOfDepartment(headOfDepartment);

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

}
