package com.attendance.repository;

import com.attendance.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findBySessionId(Long sessionId);
    Optional<Attendance> findBySessionIdAndStudentId(Long sessionId, Long studentId);
    Boolean existsBySessionIdAndStudentId(Long sessionId, Long studentId);

    @Query("SELECT a FROM Attendance a WHERE a.student.id = :studentId " +
            "AND a.session.subject.id = :subjectId")
    List<Attendance> findByStudentIdAndSubjectId(
            @Param("studentId") Long studentId,
            @Param("subjectId") Long subjectId
    );

    @Query("SELECT a FROM Attendance a WHERE a.session.subject.classEntity.id = :classId " +
            "AND a.markedAt BETWEEN :startDate AND :endDate")
    List<Attendance> findByClassIdAndDateRange(
            @Param("classId") Long classId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    @Query("SELECT COUNT(a) FROM Attendance a WHERE a.student.id = :studentId " +
            "AND a.session.subject.id = :subjectId")
    Long countByStudentIdAndSubjectId(
            @Param("studentId") Long studentId,
            @Param("subjectId") Long subjectId
    );
}