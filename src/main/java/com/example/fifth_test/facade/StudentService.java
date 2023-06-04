package com.example.fifth_test.facade;

import com.example.fifth_test.beans.Student;
import com.example.fifth_test.exception.SchoolSystemException;
import com.example.fifth_test.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   private StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
    public long addStudent(Student student){
        studentRepo.save(student);
        return student.getId();
    }
    public void deleteStudent(long id) throws SchoolSystemException {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        }
        else
            throw new SchoolSystemException("Id not found");
    }
    public List<Student>getAllStudents(){
        return studentRepo.findAll();
    }
    public Student getOneStudent(long id) throws SchoolSystemException {
        return studentRepo.findById(id).orElseThrow(()->new SchoolSystemException("Id not found!"));
    }
    public List <Student> getAllStudentsByName(String name){
        return studentRepo.findByName(name);
    }
    public List <Student>findByOrderByNameZa(){
        return studentRepo.findByOrderByNameAsc();
    }
    public List <Student>findByOrderByNameAz(){
        return studentRepo.findByOrderByNameDesc();
    }
}
