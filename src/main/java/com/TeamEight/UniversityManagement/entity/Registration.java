package com.TeamEight.UniversityManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Registration.TABLE_NAME)
public class Registration {
    @Id
    private String registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="professor_id")
    private Professor professorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subject_id")
    private Subject subjectId;

    private int semester;
    private int score;

    public static final String TABLE_NAME = "REGISTRATION";

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Professor getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Professor professorId) {
        this.professorId = professorId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId='" + registrationId + '\'' +
                ", studentId=" + studentId +
                ", professorId=" + professorId +
                ", subjectId=" + subjectId +
                ", semester=" + semester +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return semester == that.semester &&
                score == that.score &&
                Objects.equals(registrationId, that.registrationId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(professorId, that.professorId) &&
                Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(registrationId, studentId, professorId, subjectId, semester, score);
    }
}
