package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.AdminLoginRequest;
import com.example.StudentManagementSystem.model.Admin;
import com.example.StudentManagementSystem.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository){
        this.repository=repository;
    }
    public Admin registerAdmin(Admin admin){
        return repository.save(admin);
    }
   public String login(AdminLoginRequest request) {
       Admin admin = repository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("Invalid username or password"));
       if (!admin.getPassword().equals(request.getPassword())) {
           throw new RuntimeException("Invalid username or password");
       }
       return "Admin login successful";
   }
   }

