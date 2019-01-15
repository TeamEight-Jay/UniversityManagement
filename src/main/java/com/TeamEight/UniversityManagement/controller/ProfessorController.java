package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.ProfessorDTO;
import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
        @Autowired
        ProfessorService professorService;

        @PostMapping("/add")
        public ProfessorDTO add(@RequestBody ProfessorDTO professorDTO) {
            Professor professor = new Professor();
            BeanUtils.copyProperties(professorDTO, professor);
            professorService.add(professor);
            return null;
        }

        @RequestMapping(value = "/select", method = RequestMethod.GET)
        public ProfessorDTO select(@PathVariable String id) {
            professorService.select(id);
            return null;
        }
    }

}
