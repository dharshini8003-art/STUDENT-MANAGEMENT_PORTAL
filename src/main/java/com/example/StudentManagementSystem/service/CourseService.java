package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    // Add a new course
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    // Get a course by ID
    public Course getCourseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with ID: " + id));
    }

    // Update an existing course
    public Course updateCourse(Long id, Course course) {
        Course existing = getCourseById(id);

        existing.setCourseName(course.getCourseName());
        existing.setFees(course.getFees());
        existing.setDuration(course.getDuration());

        return repository.save(existing);
    }

    // Delete a course
    public void deleteCourse(Long id) {
        Course existing = getCourseById(id);
        repository.delete(existing);
    }

}