package com.example.StudentManagementSystem.dto;

public class MarkReport {

    private String courseName;
    private String courseCode;
    private double internalMark;
    private double externalMark;
    private double total;
    private String grade;

    public MarkReport() {
    }

    public MarkReport(
            String courseName,
            String courseCode,
            double internalMark,
            double externalMark,
            double total,
            String grade) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.internalMark = internalMark;
        this.externalMark = externalMark;
        this.total = total;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public double getInternalMark() {
        return internalMark;
    }

    public void setInternalMark(double internalMark) {
        this.internalMark = internalMark;
    }

    public double getExternalMark() {
        return externalMark;
    }

    public void setExternalMark(double externalMark) {
        this.externalMark = externalMark;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}