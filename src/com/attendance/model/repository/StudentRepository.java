package com.attendance.model.repository;

import com.attendance.model.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNo(String rollNo);
    Optional<Student> findByUserId(Long userId);
    List<Student> findByClassEntityId(Long classId);
    Boolean existsByRollNo(String rollNo);

    @Query("SELECT s FROM Student s WHERE s.rollNo = :rollNo AND s.user.pin = :pin")
    Optional<Student> findByRollNoAndPin(@Param("rollNo") String rollNo, @Param("pin") String pin);
}