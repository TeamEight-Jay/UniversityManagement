package com.TeamEight.UniversityManagement.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Professor.TABLE_NAME)
public class Professor {

    @Id
    private String professorId;

    private String professorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="primary_department",referencedColumnName = "departmentId")
    private Department primaryDepartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="secondary_department",referencedColumnName = "departmentId")
    private Department secondaryDepartment;

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @OneToMany(mappedBy = "professorId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrationList=new ArrayList<Registration>();


    static final String TABLE_NAME = "PROFESSOR";

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Department getPrimaryDepartment() {
        return primaryDepartment;
    }

    public void setPrimaryDepartment(Department primaryDepartment) {
        this.primaryDepartment = primaryDepartment;
    }

    public Department getSecondaryDepartment() {
        return secondaryDepartment;
    }

    public void setSecondaryDepartment(Department secondaryDepartment) {
        this.secondaryDepartment = secondaryDepartment;
    }

    @Override
    public String toString() {
        return "ProfessorRepository{" +
                "professorID='" + professorId + '\'' +
                ", professorName='" + professorName + '\'' +
                ", primaryDepartment=" + primaryDepartment +
                ", secondaryDepartment=" + secondaryDepartment +
                '}';
    }
}
