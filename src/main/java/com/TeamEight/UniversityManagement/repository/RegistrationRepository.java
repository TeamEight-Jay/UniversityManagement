package com.TeamEight.UniversityManagement.repository;

import com.TeamEight.UniversityManagement.entity.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<Registration, String> {
}
