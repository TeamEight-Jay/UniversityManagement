package com.TeamEight.UniversityManagement.services.impl;

import com.TeamEight.UniversityManagement.entity.Registration;
import com.TeamEight.UniversityManagement.repository.RegistrationRepository;
import com.TeamEight.UniversityManagement.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public Registration add(Registration registration) {
        Registration addedRegistration = registrationRepository.save(registration);
        return addedRegistration;
    }

    @Override
    public Registration select(String registrationId) {

        return registrationRepository.findOne(registrationId);
    }
}
