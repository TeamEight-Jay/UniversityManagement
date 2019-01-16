package com.TeamEight.UniversityManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = Department.TABLE_NAME)
public class Department {

    @Id
    private String departmentId;

    private String departmentName;

    public static final String TABLE_NAME = "DEPARTMENT";


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

    @Override
    public String toString() {
        return "DepartmentRepository{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(departmentId, departmentName);
    }
}
