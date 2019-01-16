package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.SubjectDTO;
import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.entity.Subject;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import com.TeamEight.UniversityManagement.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/subject")
@RestController
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/add")
	public SubjectDTO add(@RequestBody SubjectDTO subjectDTO) {
		Subject subject=new Subject();
		BeanUtils.copyProperties(subjectDTO,subject);
		Department department=departmentService.select(subjectDTO.getDepartment());
		subject.setDepartment(department);

		Subject subjectCreated=subjectService.add(subject);
		SubjectDTO subjectDTOCreated=new SubjectDTO();
		BeanUtils.copyProperties(subjectCreated,subjectDTOCreated);
		subjectDTOCreated.setDepartment(subjectCreated.getDepartment().getDepartmentId());
		return subjectDTOCreated;
	}

	@GetMapping("/select/{subjectId}")
	public SubjectDTO select(@PathVariable String subjectId) {
		Subject subject=subjectService.select(subjectId);
		SubjectDTO subjectDTO=new SubjectDTO();
		BeanUtils.copyProperties(subject,subjectDTO);
		subjectDTO.setDepartment(subject.getDepartment().getDepartmentId());
		return subjectDTO;
	}

}
