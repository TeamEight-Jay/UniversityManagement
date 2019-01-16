package com.TeamEight.UniversityManagement.services.impl;

import com.TeamEight.UniversityManagement.entity.Department;
import com.TeamEight.UniversityManagement.repository.DepartmentRepository;
import com.TeamEight.UniversityManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Department add(Department department) {
		Department addDepartment = departmentRepository.save(department);
		return addDepartment;
	}

	@Override
	public Department select(String departmentId) {
		System.out.println(departmentId);
		return departmentRepository.findOne(departmentId);
	}
}
