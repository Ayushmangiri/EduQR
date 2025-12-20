package com.attendance.repository;

import com.attendance.model.Session;
import com.attendance.model.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByToken(String token);
    List<Session> findBySubjectId(Long subjectId);
    List<Session> findBySubjectIdAndStatus(Long subjectId, SessionStatus status);

    @Query("SELECT s FROM Session s WHERE s.subject.teacher.id = :teacherId " +
            "ORDER BY s.startTime DESC")
    List<Session> findByTeacherId(@Param("teacherId") Long teacherId);

    @Query("SELECT s FROM Session s WHERE s.expiryTime < :now AND s.status = 'ACTIVE'")
    List<Session> findExpiredSessions(@Param("now") LocalDateTime now);
}