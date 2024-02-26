package com.example.MappingOneToManyDemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.ToString;

@Entity
public class Courses {
    @Id
    private int courseId;
    private String courseName;
    private String courseGuide;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

    public Courses() {
    }

    public Courses(int courseId, String courseName, String courseGuide) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseGuide = courseGuide;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseGuide() {
        return courseGuide;
    }

    public void setCourseGuide(String courseGuide) {
        this.courseGuide = courseGuide;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
