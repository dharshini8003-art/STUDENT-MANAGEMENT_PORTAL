package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.model.Attendance;
import com.example.StudentManagementSystem.service.AttendanceService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    // Mark attendance
    @PostMapping
    public Attendance markAttendance(
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            @RequestParam String status) {

        return service.markAttendance(
                studentId, courseId, status);
    }

    // Get all attendance records
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return service.getAllAttendance();
    }

    // Get attendance by Student ID
    @GetMapping("/student/{studentId}")
    public List<Attendance> getStudentAttendance(
            @PathVariable Long studentId) {

        return service.getStudentAttendance(studentId);
    }

    // Get attendance by Course ID
    @GetMapping("/course/{courseId}")
    public List<Attendance> getCourseAttendance(
            @PathVariable Long courseId) {

        return service.getCourseAttendance(courseId);
    }

    // Get attendance by Student ID and Course ID
    @GetMapping("/student/{studentId}/course/{courseId}")
    public List<Attendance> getStudentCourseAttendance(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return service.getStudentCourseAttendance(
                studentId, courseId);
    }

    // Calculate attendance percentage
    @GetMapping("/percentage")
    public double getPercentage(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        return service.calculatePercentage(
                studentId, courseId);
    }

    // Delete attendance record
    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        service.deleteAttendance(id);
        return "Attendance deleted successfully";
    }
}