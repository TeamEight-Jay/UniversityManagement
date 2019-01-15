package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Subject;
import com.TeamEight.UniversityManagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject add(Subject subject) {
        Subject addedSubject=subjectRepository.save(subject);
        return addedSubject;
    }

    @Override
    public Subject select(String subjectId) {
        return subjectRepository.findOne(subjectId);
    }
}
