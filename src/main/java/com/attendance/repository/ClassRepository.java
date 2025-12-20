package com.attendance.repository;

import com.attendance.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    List<ClassEntity> findByDepartment(String department);
    List<ClassEntity> findBySemester(Integer semester);
}