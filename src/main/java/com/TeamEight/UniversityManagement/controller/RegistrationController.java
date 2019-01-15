package com.TeamEight.UniversityManagement.controller;

import com.TeamEight.UniversityManagement.dto.RegistrationDTO;
import com.TeamEight.UniversityManagement.entity.Registration;
import com.TeamEight.UniversityManagement.helper.DTOConvertor;
import com.TeamEight.UniversityManagement.helper.EntityConvertor;
import com.TeamEight.UniversityManagement.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/registration")
@RestController

public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/add")
    public RegistrationDTO add(@RequestBody RegistrationDTO registrationDTO){
        Registration registration=DTOConvertor.toRegistrationEntity(registrationDTO);
        Registration registrationCreated = registrationService.add(registration);
        return EntityConvertor.toRegistrationDTO(registrationCreated);
    }

    @GetMapping("/select/{registrationId}")
    public RegistrationDTO select(@PathVariable String registrationId){
        Registration registration = registrationService.select(registrationId);
        RegistrationDTO registrationDTO = EntityConvertor.toRegistrationDTO(registration);
        return registrationDTO;
    }
}
