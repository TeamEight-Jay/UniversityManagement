package com.TeamEight.UniversityManagement.repository;

import com.TeamEight.UniversityManagement.entity.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface RegistrationRepository extends CrudRepository<Registration, String> {
    @Query(value = "SELECT SUM(score) FROM Registration WHERE Registration.studentId=Student.studentId " +
            "&&" + "Registration.semester= :semester ", nativeQuery = true)
    int findTotalSemesterScore(@Param("semester") int semester);

    @Query(value = "SELECT COUNT(score) FROM Registration WHERE Registration.studentId=Student.studentId " +
            "&&" + "Registration.semester= :semester ", nativeQuery = true)
    int findTotalSemesterSubjectCount(@Param("semester") int semester);

    @Query(value = "SELECT SUM(score) FROM Registration WHERE Registration.professorId=:professorId " +
            "&&" + "Registration.subjectId= :subjectId ", nativeQuery = true)
    int findProfessorSubjectScore(@Param("professorId") int professorId, @Param("subjectId") String subjectId);

    @Query(value = "SELECT COUNT(score) FROM Registration WHERE Registration.professorId=:professorId " +
            "&&" + "Registration.subjectId= :subjectId ", nativeQuery = true)
    int findProfessorSubjectStudentStrength(@Param("professorId") int professorId, @Param("subjectId") String subjectId);

}


