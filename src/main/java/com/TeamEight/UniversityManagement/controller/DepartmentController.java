package com.TeamEight.UniversityManagement.controller;
import com.TeamEight.UniversityManagement.dto.DepartmentDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value ="/add",method = RequestMethod.POST )
    public String create(@RequestBody DepartmentDTO department) {
        departmentService.add(department);
        String s = "created";
        return s;
    }
    @RequestMapping(value = "/select" , method = RequestMethod.GET)
    public DepartmentDTO select(@RequestParam("id") String id) {
        Department department = departmentService.select(id);
        DepartmentDTO departmentdto = new DepartmentDTO();
        BeanUtils.copyProperties(department, departmentdto);
        return departmentdto;
    }
}
