package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Professor;

public interface ProfessorService {

    Professor add(Professor professor);

    Professor select(String professorId);
}
