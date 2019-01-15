package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/subject")
@RestController
public class SubjectController {
	@Autowired
	SubjectService subjectService;
	@RequestMapping("/add")
	public SubjectDTO add(@RequestBody SubjectDTO subjectDTO){

	}
}
