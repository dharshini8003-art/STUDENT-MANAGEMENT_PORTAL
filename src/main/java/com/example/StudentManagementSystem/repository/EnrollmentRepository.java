package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository
        extends JpaRepository<Enrollment, Long> {

    // Find enrollments using Student ID
    List<Enrollment> findByStudent_Id(Long studentId);

    // Find enrollments using Course ID
    List<Enrollment> findByCourse_Id(Long courseId);
}