package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Department;

public interface DepartmentService {

    Department add(Department department);

    Department select(String departmentId);
}
