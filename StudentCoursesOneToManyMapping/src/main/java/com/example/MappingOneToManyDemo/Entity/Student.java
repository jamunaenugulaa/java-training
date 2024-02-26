package com.example.MappingOneToManyDemo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Courses> coursesList=new ArrayList<>();

    public Student() {

    }

    public Student(int id, String name, int age, List<Courses> coursesList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coursesList = coursesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
