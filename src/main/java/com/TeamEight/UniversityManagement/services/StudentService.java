package com.TeamEight.UniversityManagement.services;

import com.TeamEight.UniversityManagement.entity.Student;

public interface StudentService {

    Student add(Student student);

    Student select(String studentId);

    double getCGPA(String studentId);

    double getSGPA(String studentId,int semester);
}
