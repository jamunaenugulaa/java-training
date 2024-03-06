package com.example.EmployeeProjectMapping.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private int projectId;
    private String  projectName;
    private String projectGuide;
    private LocalDate startDate;
    private LocalDate  endDate;
    private int employesRequired;
    private int duration;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

    @ManyToMany(mappedBy = "projectList",cascade = CascadeType.ALL)
    private List<Employee> employeeList=new ArrayList<>();


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectGuide() {
        return projectGuide;
    }

    public void setProjectGuide(String projectGuide) {
        this.projectGuide = projectGuide;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getEmployesRequired() {
        return employesRequired;
    }

    public void setEmployesRequired(int employesRequired) {
        this.employesRequired = employesRequired;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
