package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByUsername(String username);
}
