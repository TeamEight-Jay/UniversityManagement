package com.TeamEight.UniversityManagement;

import com.TeamEight.UniversityManagement.controller.DepartmentController;
import com.TeamEight.UniversityManagement.entity.*;
import com.TeamEight.UniversityManagement.repository.*;
import com.TeamEight.UniversityManagement.services.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class JUnitTest {

    private  Department department;
    private  Professor professor;
    private  Registration registration;
    private  Student student;
    private  Subject subject;

    @InjectMocks
    private  DepartmentServiceImpl departmentServiceImpl;
    @InjectMocks
    private  ProfessorServiceImpl professorService;
    @InjectMocks
    private  RegistrationServiceImpl registrationService;
    @InjectMocks
    private  StudentServiceImpl studentService;
    @InjectMocks
    private  SubjectServiceImpl subjectService;

    @Mock
    private  DepartmentRepository departmentRepository;
    @Mock
    private  ProfessorRepository professorRepository;
    @Mock
    private  RegistrationRepository registrationRepository;
    @Mock
    private  StudentRepository studentRepository;
    @Mock
    private  SubjectRepository subjectRepository;

    @Before
    public  void setup()
    {

        department=new Department();
        department.setDepartmentId("D1");
        department.setDepartmentName("Computer Science");

        subject=new Subject();
        subject.setSubjectId("MATH1");
        subject.setSubjectName("MATHS 1");
        subject.setDepartment(department);

        professor=new Professor();
        professor.setProfessorId("P1");
        professor.setProfessorName("ABC XYZ");
        professor.setPrimaryDepartment(department);
        professor.setSecondaryDepartment(department);

        student=new Student();
        student.setStudentId("S1");
        student.setStudentName("PQR LMN");
        student.setDepartment(department);
        student.setCourse("QWERTY");
        student.setYearOfJoining(1234);

        registration=new Registration();
        registration.setSubjectId(subject);
        registration.setProfessorId(professor);
        registration.setStudentId(student);
        registration.setRegistrationId("R1");
        registration.setScore(60);
        registration.setSemester(2);

        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        Mockito.when(professorRepository.save(professor)).thenReturn(professor);
        Mockito.when(registrationRepository.save(registration)).thenReturn(registration);
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Mockito.when(subjectRepository.save(subject)).thenReturn(subject);

        Mockito.when(departmentRepository.findOne(department.getDepartmentId())).thenReturn(department);
        Mockito.when(professorRepository.findOne(professor.getProfessorId())).thenReturn(professor);
        Mockito.when(registrationRepository.findOne(registration.getRegistrationId())).thenReturn(registration);
        Mockito.when(studentRepository.findOne(student.getStudentId())).thenReturn(student);
        Mockito.when(subjectRepository.findOne(subject.getSubjectId())).thenReturn(subject);


    }


    @Test
    public void departmentInsertTest()
    {
        Assert.assertEquals(department, departmentServiceImpl.add(department));
    }


    @Test
    public void professorInsertTest()
    {
        Assert.assertEquals(professor,professorService.add(professor));
    }

    @Test
    public void registrationInsertTest()
    {
        Assert.assertEquals(registration,registrationService.add(registration));
    }

    @Test
    public void studentInsertTest()
    {
        Assert.assertEquals(student,studentService.add(student));
    }

    @Test
    public void subjectInsertTest()
    {
        Assert.assertEquals(subject,subjectService.add(subject));
    }

    @Test
    public void departmentSelectTest() throws Exception {

        Assert.assertEquals(department, departmentServiceImpl.add(department));
    }


    @Test
    public void professorSelectTest()
    {
        Assert.assertEquals(professor,professorService.add(professor));
    }

    @Test
    public void registrationSelectTest()
    {
        Assert.assertEquals(registration,registrationService.add(registration));
    }

    @Test
    public void studentSelectTest()
    {
        Assert.assertEquals(student,studentService.add(student));
    }

    @Test
    public void subjectSelectTest()
    {
        Assert.assertEquals(subject,subjectService.add(subject));
    }

}
