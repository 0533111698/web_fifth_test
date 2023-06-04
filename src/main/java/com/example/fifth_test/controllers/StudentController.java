package com.example.fifth_test.controllers;

import com.example.fifth_test.beans.Student;
import com.example.fifth_test.exception.SchoolSystemException;
import com.example.fifth_test.facade.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
       return ResponseEntity.status(HttpStatus.CREATED).body("Student with id:"+service.addStudent(student)+" added!");
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String>deleteStudent(@PathVariable long id){
        try {
            service.deleteStudent(id);
            return ResponseEntity.ok("Student deleted!");
        } catch (SchoolSystemException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public List<Student>getAllStudents(){
        return service.getAllStudents();
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?>getOneStudent(@PathVariable long id){
        try {
            return ResponseEntity.ok().body(service.getOneStudent(id));
        } catch (SchoolSystemException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @GetMapping("/getAllByName/{name}")
    public List<Student>getAllByName(@PathVariable String name){
        return service.getAllStudentsByName(name);
    }
    @GetMapping("/getAllZa")
    public List<Student>getAllZa(){
        return service.findByOrderByNameAz();
    }
    @GetMapping("/getAllAz")
    public List<Student>getAllAz(){
        return service.findByOrderByNameZa();
    }



}
