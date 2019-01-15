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
            Department department = new Department();
            BeanUtils.copyProperties(departmentDTO, department);
            departmentService.add(department);
            return null;
        }

        @RequestMapping(value = "/select", method = RequestMethod.GET)
        public DepartmentDTO select(@PathVariable String id) {
            departmentService.select(id);
            return null;
        }
    }

