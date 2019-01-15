package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Registration;

public interface RegistrationService {

    Registration add(Registration registration);

    Registration select(String registrationId);
}
