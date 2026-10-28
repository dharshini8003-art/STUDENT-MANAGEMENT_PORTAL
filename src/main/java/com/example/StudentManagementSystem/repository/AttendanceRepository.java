package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudent_Id(Long studentId);

    List<Attendance> findByCourse_Id(Long courseId);

    List<Attendance> findByStudent_IdAndCourse_Id(
            Long studentId, Long courseId);

    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByCourseId(Long courseId);

    List<Attendance> findByStudentIdAndCourseId(Long studentId, Long courseId);
}