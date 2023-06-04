package com.example.fifth_test.repository;

import com.example.fifth_test.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student>findByName(String name);
    public List<Student> findByOrderByNameDesc();
    public List<Student> findByOrderByNameAsc();

}
