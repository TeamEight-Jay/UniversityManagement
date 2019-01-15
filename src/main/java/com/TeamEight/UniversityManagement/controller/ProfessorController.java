package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.ProfessorDTO;
import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.helper.DTOConvertor;
import com.TeamEight.UniversityManagement.helper.EntityConvertor;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
        @Autowired
        ProfessorService professorService;

        @PostMapping("/add")
        public ProfessorDTO add(@RequestBody ProfessorDTO professorDTO){
            Professor professor=DTOConvertor.toProfessorEntity(professorDTO);
            Professor professorCreated=professorService.add(professor);
            return EntityConvertor.toProfessorDTO(professorCreated);
        }
    @GetMapping("/select/{professorId}")
    public ProfessorDTO select(@PathVariable String professorId) {
        Professor professor = professorService.select(professorId);
        ProfessorDTO professorDTO = EntityConvertor.toProfessorDTO(professor);
        return professorDTO;
    }
    }

