package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // Add a new student
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with ID: " + id));
    }

    // Update student details
    public Student updateStudent(Long id, Student student) {
        Student existing = getStudentById(id);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setDepartment(student.getDepartment());
        existing.setYear(student.getYear());

        return repository.save(existing);
    }

    // Delete student by ID
    public void deleteStudentById(Long id) {
        Student existing = getStudentById(id);
        repository.delete(existing);
    }
}