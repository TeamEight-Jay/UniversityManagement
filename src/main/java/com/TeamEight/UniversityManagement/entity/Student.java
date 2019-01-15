package com.TeamEight.UniversityManagement.entity;

public class Student {
    private String studentId;
    private String studentName;
    private int yearOfJoining;
    private String course;
    private Department department;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", course='" + course + '\'' +
                ", department=" + department +
                '}';
    }
}
