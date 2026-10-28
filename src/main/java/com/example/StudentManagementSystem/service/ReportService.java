package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.MarkReport;
import com.example.StudentManagementSystem.dto.StudentReport;
import com.example.StudentManagementSystem.model.Mark;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.MarkRepository;
import com.example.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;

    public ReportService(
            StudentRepository studentRepository,
            MarkRepository markRepository) {

        this.studentRepository = studentRepository;
        this.markRepository = markRepository;
    }

    public StudentReport generateStudentReport(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        List<Mark> marks =
                markRepository.findByStudent_Id(studentId);

        List<MarkReport> markReports = marks.stream()
                .map(mark -> new MarkReport(
                        mark.getCourse().getCourseName(),
                        mark.getCourse().getDuration(),
                        mark.getInternalMark(),
                        mark.getExternalMark(),
                        mark.getTotal(),
                        mark.getGrade()
                ))
                .toList();

        StudentReport report = new StudentReport();

        report.setStudentId(student.getId());
        report.setStudentName(student.getName());
        report.setEmail(student.getEmail());
        report.setDepartment(student.getDepartment());
        report.setYear(student.getYear());
        report.setMarks(markReports);

        return report;
    }
}