package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark,Long> {
    List<Mark> findMarkByStudentId(Long studentId);
    List<Mark> findMarkByCourseId(Long courseId);
    List<Mark> findMarkByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Mark> findByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Mark> findByCourseId(Long courseId);

    List<Mark> findByStudentId(Long studentId);

    List<Mark> findByStudent_Id(Long studentId);
}
