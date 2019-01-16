package com.TeamEight.UniversityManagement.services.impl;

import com.TeamEight.UniversityManagement.entity.Registration;
import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.repository.StudentRepository;
import com.TeamEight.UniversityManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student add(Student student) {
        Student addedStudent=studentRepository.save(student);
        return addedStudent;
    }

    @Override
    public Student select(String studentId) {
        return studentRepository.findOne(studentId);
    }

    @Override
    public int getCGPA(String studentId) {
        Student student=this.select(studentId);
        int earnedCredit=0;
        int offeredCredit=0;
        List<Registration> registrationList=student.getRegistrationList();

        for(Registration registration:registrationList)
        {

        }

        return earnedCredit/offeredCredit;

    }


}
