package com.TeamEight.UniversityManagement.entity;

import javax.persistence.Entity;

@Entity
public class Department {
    private String departmentId;
    private String departmentName;
    private Professor headOfDepartment;


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Professor getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Professor headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                '}';
    }
}