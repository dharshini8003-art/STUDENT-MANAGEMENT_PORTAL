package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByUsername(String username);
}
