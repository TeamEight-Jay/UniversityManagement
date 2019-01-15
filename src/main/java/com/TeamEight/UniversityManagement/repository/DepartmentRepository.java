package com.TeamEight.UniversityManagement.repository;

import com.TeamEight.UniversityManagement.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, String> {
}
