package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Attendance;
import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.model.Student;

import com.example.StudentManagementSystem.repository.AttendanceRepository;
import com.example.StudentManagementSystem.repository.CourseRepository;
import com.example.StudentManagementSystem.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public AttendanceService(
            AttendanceRepository attendanceRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Mark student attendance
    public Attendance markAttendance(
            Long studentId,
            Long courseId,
            String status) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Course not found: " + courseId));

        if (status == null ||
                !(status.equalsIgnoreCase("PRESENT")
                        || status.equalsIgnoreCase("ABSENT"))) {

            throw new IllegalArgumentException(
                    "Status must be PRESENT or ABSENT");
        }

        Attendance attendance = new Attendance();

        attendance.setStudent(student);
        attendance.setCourse(course);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(status.toUpperCase());

        return attendanceRepository.save(attendance);
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance by Student ID
    public List<Attendance> getStudentAttendance(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    // Get attendance by Course ID
    public List<Attendance> getCourseAttendance(Long courseId) {
        return attendanceRepository.findByCourseId(courseId);
    }

    // Get attendance by Student ID and Course ID
    public List<Attendance> getStudentCourseAttendance(
            Long studentId,
            Long courseId) {

        return attendanceRepository
                .findByStudentIdAndCourseId(studentId, courseId);
    }

    // Calculate attendance percentage
    public double calculatePercentage(
            Long studentId,
            Long courseId) {

        List<Attendance> records =
                attendanceRepository
                        .findByStudentIdAndCourseId(
                                studentId, courseId);

        if (records.isEmpty()) {
            return 0.0;
        }

        long present = records.stream()
                .filter(a -> a.getStatus() != null
                        && a.getStatus().equalsIgnoreCase("PRESENT"))
                .count();

        return (present * 100.0) / records.size();
    }

    // Delete attendance record
    public void deleteAttendance(Long id) {

        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Attendance record not found: " + id));

        attendanceRepository.delete(attendance);
    }
}