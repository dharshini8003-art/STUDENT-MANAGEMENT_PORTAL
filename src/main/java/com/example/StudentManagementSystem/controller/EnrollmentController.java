package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.model.Enrollment;
import com.example.StudentManagementSystem.service.EnrollmentService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    // Enroll a student using Student ID and Course ID
    @PostMapping
    public Enrollment enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        return service.enrollStudent(studentId, courseId);
    }

    // Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    // Get enrollments by Student ID
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getStudentEnrollments(
            @PathVariable Long studentId) {
        return service.getStudentEnrollments(studentId);
    }

    // Get enrollments by Course ID
    @GetMapping("/course/{courseId}")
    public List<Enrollment> getCourseEnrollments(
            @PathVariable Long courseId) {
        return service.getCourseEnrollments(courseId);
    }

    // Delete enrollment
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        service.deleteEnrollment(id);
        return "Enrollment deleted successfully";
    }
}