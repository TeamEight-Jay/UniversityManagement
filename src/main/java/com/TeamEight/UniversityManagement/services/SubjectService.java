package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Subject;

public interface SubjectService {

    Subject add(Subject subject);

    Subject select(String subjectId);
}
