package com.TeamEight.UniversityManagement.services.impl;

import com.TeamEight.UniversityManagement.entity.Professor;
import com.TeamEight.UniversityManagement.repository.ProfessorRepository;
import com.TeamEight.UniversityManagement.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	final double AVERAGE_SCORE_WEIGHTAGE=0.8;
	final double STUDENT_COUNT_WEIGHTAGE=1-AVERAGE_SCORE_WEIGHTAGE;
	@Autowired
	ProfessorRepository professorRepository;
	@Override
	public Professor add(Professor professor) {
		Professor professorAdded = professorRepository.save(professor);
		return professorAdded;
	}

	@Override
	public Professor select(String professorId) {
		return professorRepository.findOne(professorId);
	}

	@Override
	public double rating(String professorId) {
		Professor professor=this.select(professorId);
		return 0;
	}
}
