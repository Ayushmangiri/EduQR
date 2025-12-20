package com.attendance.model.repository;

import com.attendance.model.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByCode(String code);
    List<Subject> findByClassEntityId(Long classId);
    List<Subject> findByTeacherId(Long teacherId);
}