package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Student;
import com.TeamEight.UniversityManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
