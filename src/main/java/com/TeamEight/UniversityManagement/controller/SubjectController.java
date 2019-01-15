package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.SubjectDTO;
import com.TeamEight.UniversityManagement.entity.Subject;
import com.TeamEight.UniversityManagement.helper.DTOConvertor;
import com.TeamEight.UniversityManagement.helper.EntityConvertor;
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
		Subject subject = DTOConvertor.toSubjectEntity(subjectDTO);
		Subject subjectCreated=subjectService.add(subject);
		return EntityConvertor.toSubjectDTO(subjectCreated);
	}

	@GetMapping("/select/{subjectId}")
	public SubjectDTO select(@PathVariable String subjectId) {
		Subject subject=subjectService.select(subjectId);
		SubjectDTO subjectDTO=EntityConvertor.toSubjectDTO(subject);
		return subjectDTO;
	}

}
