package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.AdminLoginRequest;
import com.example.StudentManagementSystem.model.Admin;
import com.example.StudentManagementSystem.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    private final AdminService Service;
    public AdminController(AdminService Service) {
        this.Service = Service;
    }
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin){
        return Service.registerAdmin(admin);
    }
    @PostMapping("/login")
    public String login(@RequestBody AdminLoginRequest request){
        return Service.login(request);
    }
}
