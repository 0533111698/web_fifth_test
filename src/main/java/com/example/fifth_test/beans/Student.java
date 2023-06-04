package com.example.fifth_test.beans;

import jdk.jfr.BooleanFlag;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date birthday;
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Grade>grades;

    public Student() {
    }

    public Student(String name, Date birthday, boolean isActive, List<Grade> grades) {
        this.name = name;
        this.birthday = birthday;
        this.isActive = isActive;
        this.grades = grades;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
