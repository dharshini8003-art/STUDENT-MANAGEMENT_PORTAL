package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.model.Mark;
import com.example.StudentManagementSystem.service.MarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin
public class MarkController {
  private final MarkService Service;
  public MarkController(MarkService Service) {
      this.Service = Service;
  }
  @PostMapping
  public Mark addMark(@RequestParam Long studentId, @RequestParam Long courseId,@RequestParam double internalMark,@RequestParam double externalMark) {
    return Service.addMark(studentId,courseId,internalMark,externalMark);
  }
  @GetMapping
  public List<Mark> findAll() {
    return Service.getAllMarks();
  }
  @GetMapping("/{id}")
    public Mark getMark(@PathVariable Long id) {
      return Service.getMarkById(id);
  }
  @GetMapping("/student/{studentId}")
  public List<Mark> getStudentMarks(@PathVariable Long studentId) {
      return Service.getStudentMarks(studentId);
  }
      @GetMapping("/course/{courseId}")
      public List<Mark> getCourseMarks (@PathVariable Long courseId){
          return Service.getCourseMarks(courseId);
      }
    @GetMapping("/student/{studentId}/course/{courseId}")
    public List<Mark> getStudentCourseMarks(@PathVariable Long studentId,@PathVariable Long courseId){
        return Service.getStudentCourseMarks(studentId,courseId);
    }
 @PutMapping("/{id}")
    public Mark updateMark(@PathVariable Long id,@RequestParam double internalMark,@RequestParam double externalMark) {
      return Service.updateMark(id, internalMark,externalMark);
 }
 @DeleteMapping("/{id}")
    public String deleteMark(@PathVariable Long id) {
     Service.deleteMark(id);
      return "Mark deleted successfully";
 }
}
