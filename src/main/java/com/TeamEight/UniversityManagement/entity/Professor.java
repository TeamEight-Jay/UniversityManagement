package com.TeamEight.UniversityManagement.entity;

import javax.persistence.Entity;

@Entity
public class Professor {
    private String professorId;
    private String professorName;
    private Department primaryDepartment;
    private Department secondaryDepartment;

    public String getProfessorId() {return professorId;}

    public void setProfessorId(String professorId) {this.professorId = professorId;}

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
        return "Professor{" +
                "professorID='" + professorId + '\'' +
                ", professorName='" + professorName + '\'' +
                ", primaryDepartment=" + primaryDepartment +
                ", secondaryDepartment=" + secondaryDepartment +
                '}';
    }
}
