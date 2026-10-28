package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.model.Enrollment;
import com.example.StudentManagementSystem.model.Student;

import com.example.StudentManagementSystem.repository.CourseRepository;
import com.example.StudentManagementSystem.repository.EnrollmentRepository;
import com.example.StudentManagementSystem.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Enroll a student using Student ID and Course ID
    public Enrollment enrollStudent(Long studentId, Long courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Course not found: " + courseId));

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        return enrollmentRepository.save(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollments by Student ID
    public List<Enrollment> getStudentEnrollments(Long studentId) {

        return enrollmentRepository.findByStudent_Id(studentId);
    }

    // Get enrollments by Course ID
    public List<Enrollment> getCourseEnrollments(Long courseId) {

        return enrollmentRepository.findByCourse_Id(courseId);
    }

    // Delete enrollment
    public void deleteEnrollment(Long id) {

        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Enrollment not found: " + id));

        enrollmentRepository.delete(enrollment);
    }
}