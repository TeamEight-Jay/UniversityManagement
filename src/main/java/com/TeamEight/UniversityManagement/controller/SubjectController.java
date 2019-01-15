package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.SubjectDTO;
import com.TeamEight.UniversityManagement.entity.Subject;
import com.TeamEight.UniversityManagement.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/subject")
@RestController
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@PostMapping("/add")
	public SubjectDTO add(@RequestBody SubjectDTO subjectDTO) {
		Subject subject = new Subject();
		BeanUtils.copyProperties(subjectDTO, subject);
		subjectService.add(subject);
		return null;
	}

	@GetMapping("/select")
	public SubjectDTO select(@PathVariable String id) {
		subjectService.select(id);
		return null;
	}
}
