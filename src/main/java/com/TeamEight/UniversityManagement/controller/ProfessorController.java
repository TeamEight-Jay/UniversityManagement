package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.ProfessorDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
        @Autowired
        ProfessorService professorService;
        @Autowired
        DepartmentService departmentService;

        @PostMapping("/add")
        public ProfessorDTO add(@RequestBody ProfessorDTO professorDTO){

            Professor professor=new Professor();
            BeanUtils.copyProperties(professorDTO,professor);

            Department primaryDepartment=departmentService.select(professorDTO.getPrimaryDepartment());
            Department secondaryDepartment=departmentService.select(professorDTO.getSecondaryDepartment());
            professor.setPrimaryDepartment(primaryDepartment);
            professor.setSecondaryDepartment(secondaryDepartment);

            Professor professorCreated=professorService.add(professor);
            ProfessorDTO professorDTOCreated=new ProfessorDTO();
            BeanUtils.copyProperties(professorCreated,professorDTOCreated);
            professorDTOCreated.setPrimaryDepartment(professorCreated.getPrimaryDepartment().getDepartmentId());
            professorDTOCreated.setSecondaryDepartment(professorCreated.getSecondaryDepartment().getDepartmentId());

            return professorDTOCreated;
        }
        @GetMapping("/select/{professorId}")
        public ProfessorDTO select(@PathVariable String professorId) {
            Professor professor = professorService.select(professorId);
            ProfessorDTO professorDTO=new ProfessorDTO();
            BeanUtils.copyProperties(professor,professorDTO);
            professorDTO.setPrimaryDepartment(professor.getPrimaryDepartment().getDepartmentId());
            professorDTO.setSecondaryDepartment(professor.getSecondaryDepartment().getDepartmentId());
            return professorDTO;
        }

        @GetMapping("/rating/{professorId}")
        public double rating(@PathVariable String professorId)
        {
            return professorService.rating(professorId);
        }
    }

