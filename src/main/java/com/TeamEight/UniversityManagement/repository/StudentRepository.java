package com.TeamEight.UniversityManagement.repository;

import com.TeamEight.UniversityManagement.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
