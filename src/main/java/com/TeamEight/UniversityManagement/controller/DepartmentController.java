package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.DepartmentDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public DepartmentDTO add(@RequestBody DepartmentDTO departmentDTO) {
        Department department=new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        Department departmentCreated=departmentService.add(department);
        DepartmentDTO departmentDTOCreated=new DepartmentDTO();
        BeanUtils.copyProperties(departmentCreated,departmentDTOCreated);
        return departmentDTOCreated;

    }

    @GetMapping("/select/{departmentId}")
    public DepartmentDTO select(@PathVariable String departmentId) {
        Department department = departmentService.select(departmentId);
        DepartmentDTO departmentDTO=new DepartmentDTO();
        BeanUtils.copyProperties(department,departmentDTO);
        return departmentDTO;
    }
}
