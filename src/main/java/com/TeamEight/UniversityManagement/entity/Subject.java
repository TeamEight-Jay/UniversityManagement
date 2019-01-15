package com.TeamEight.UniversityManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Subject.TABLE_NAME)
public class Subject {
    private String subjectId;
    private String subjectName;
    private int maxScore;
    private Department department;
    public static final String TABLE_NAME = "SUBJECT";

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", maxScore=" + maxScore +
                ", department=" + department +
                '}';
    }
}
