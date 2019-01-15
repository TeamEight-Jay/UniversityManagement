package com.TeamEight.UniversityManagement.repository;

import com.TeamEight.UniversityManagement.entity.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, String> {
}
