package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.FacultyLoginRequest;
import com.example.StudentManagementSystem.model.Faculty;
import com.example.StudentManagementSystem.service.FacultyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin
public class FacultyController {
    private final FacultyService service;
    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public Faculty registerFaculty(@RequestBody Faculty faculty) {
        return service.registerFaculty(faculty);
    }
    @PostMapping("/login")
    public String login(@RequestBody FacultyLoginRequest request) {
        return service.login(request);
    }
}
