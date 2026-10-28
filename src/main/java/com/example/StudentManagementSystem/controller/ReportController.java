package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.StudentReport;
import com.example.StudentManagementSystem.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {
    private final ReportService reportService;
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/student/{studentId}")
    public StudentReport getStudentReport(@PathVariable Long studentId) {
        return reportService.generateStudentReport(studentId);
    }
}
