package com.attendance.model.repository;

import com.attendance.model.model.Material;
import com.attendance.model.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findBySubjectId(Long subjectId);
    List<Material> findBySubjectIdAndType(Long subjectId, MaterialType type);
    List<Material> findByUploadedBy(Long uploadedBy);
}