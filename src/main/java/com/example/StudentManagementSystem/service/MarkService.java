package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.model.Mark;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.CourseRepository;
import com.example.StudentManagementSystem.repository.MarkRepository;
import com.example.StudentManagementSystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public MarkService(
            MarkRepository markRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Mark addMark(
            Long studentId,
            Long courseId,
            double internalMark,
            double externalMark) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        if (internalMark < 0 || internalMark > 40) {
            throw new RuntimeException(
                    "Internal mark must be between 0 and 40");
        }

        if (externalMark < 0 || externalMark > 60) {
            throw new RuntimeException(
                    "External mark must be between 0 and 60");
        }

        Mark mark = new Mark();

        mark.setStudent(student);
        mark.setCourse(course);
        mark.setInternalMark(internalMark);
        mark.setExternalMark(externalMark);

        double total = internalMark + externalMark;

        mark.setTotal(total);
        mark.setGrade(calculateGrade(total));

        return markRepository.save(mark);
    }

    private String calculateGrade(double total) {

        if (total >= 90) {
            return "A+";
        } else if (total >= 80) {
            return "A";
        } else if (total >= 70) {
            return "B";
        } else if (total >= 60) {
            return "C";
        } else if (total >= 50) {
            return "D";
        } else if (total >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    public Mark getMarkById(Long id) {

        return markRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Mark record not found"));
    }

    public List<Mark> getStudentMarks(Long studentId) {

        return markRepository.findByStudentId(studentId);
    }

    public List<Mark> getCourseMarks(Long courseId) {

        return markRepository.findByCourseId(courseId);
    }

    public List<Mark> getStudentCourseMarks(
            Long studentId,
            Long courseId) {

        return markRepository
                .findByStudentIdAndCourseId(
                        studentId,
                        courseId);
    }

    public Mark updateMark(
            Long id,
            double internalMark,
            double externalMark) {

        Mark mark = getMarkById(id);

        if (internalMark < 0 || internalMark > 40) {
            throw new RuntimeException(
                    "Internal mark must be between 0 and 40");
        }

        if (externalMark < 0 || externalMark > 60) {
            throw new RuntimeException(
                    "External mark must be between 0 and 60");
        }

        mark.setInternalMark(internalMark);
        mark.setExternalMark(externalMark);

        double total = internalMark + externalMark;

        mark.setTotal(total);
        mark.setGrade(calculateGrade(total));

        return markRepository.save(mark);
    }

    public void deleteMark(Long id) {
        markRepository.deleteById(id);
    }
}