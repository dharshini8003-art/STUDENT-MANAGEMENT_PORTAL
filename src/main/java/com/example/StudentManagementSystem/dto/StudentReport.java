package com.example.StudentManagementSystem.dto;


import java.util.List;

public class StudentReport {
    private long studentId;
    private String StudentName;
    private String email;
    private String department;
    private int year;

    private List<MarkReport> marks;
    public StudentReport() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MarkReport> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkReport> marks) {
        this.marks = marks;
    }
}
