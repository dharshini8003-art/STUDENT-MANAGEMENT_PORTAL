package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.FacultyLoginRequest;
import com.example.StudentManagementSystem.model.Faculty;
import com.example.StudentManagementSystem.repository.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    private final FacultyRepository repository;
    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }
    public Faculty registerFaculty(Faculty faculty) {
        return repository.save(faculty);
    }
    public String login(FacultyLoginRequest request) {
        Faculty faculty= repository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("invalid username"));
   if(!faculty.getPassword().equals(request.getPassword())){
       throw new RuntimeException("invalid username or password");
   }
   return "Faculty login successful";
    }
}
