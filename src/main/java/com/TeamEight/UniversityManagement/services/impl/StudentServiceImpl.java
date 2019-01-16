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
    public double getCGPA(String studentId) {
        Student student=this.select(studentId);
        double earnedCredit=0;
        double offeredCredit=0;
        List<Registration> registrationList=student.getRegistrationList();

        for(Registration registration:registrationList)
        {
            System.out.println(registration.getSubjectId().getMaxScore());
            earnedCredit+=registration.getScore();
            offeredCredit+=registration.getSubjectId().getMaxScore();
        }
        if(offeredCredit==0) return 0;
        return (earnedCredit/offeredCredit)*10;

    }

    @Override
    public double getSGPA(String studentId, int semester) {
        Student student=this.select(studentId);
        double earnedCredit=0;
        double offeredCredit=0;
        List<Registration> registrationList=student.getRegistrationList();

        for(Registration registration:registrationList)
        {
            if(registration.getSemester()==semester)
            {
                earnedCredit += registration.getScore();
                offeredCredit += registration.getSubjectId().getMaxScore();
            }
        }
        if(offeredCredit==0) return 0;
        return (earnedCredit/offeredCredit)*10;
    }


}
