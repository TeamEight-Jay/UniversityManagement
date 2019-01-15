package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.DepartmentDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.helper.DTOConvertor;
import com.TeamEight.UniversityManagement.helper.EntityConvertor;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public DepartmentDTO add(@RequestBody DepartmentDTO departmentDTO) {
        Department department = DTOConvertor.toDepartmentEntity(departmentDTO);
        Department departmentCreated=departmentService.add(department);
        return EntityConvertor.toDepartmentDTO(departmentCreated);
    }

    @GetMapping("/select/{departmentId}")
    public DepartmentDTO select(@PathVariable String departmentId) {
        Department department = departmentService.select(departmentId);
        DepartmentDTO departmentDTO = EntityConvertor.toDepartmentDTO(department);
        return departmentDTO;
    }
}
