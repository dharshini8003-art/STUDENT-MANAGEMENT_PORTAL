package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.model.Course;
import com.example.StudentManagementSystem.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id){
        return service.getCourseById(id);
    }
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        return service.updateCourse(id, course);
    }
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id){
        service.deleteCourse(id);
        return "course deleted successfully";
    }
}

