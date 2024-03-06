package com.example.EmployeeProjectMapping.Model;

import com.example.EmployeeProjectMapping.Entity.Admin;
import com.example.EmployeeProjectMapping.Entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectModel {
    private int projectId;
    private String  projectName;
    private String projectGuide;
    private LocalDate startDate;
    private LocalDate  endDate;
    private int employesRequired;
    private int duration;
    private Admin admin;
    private List<Employee> employeeList=new ArrayList<>();

    public ProjectModel() {
    }

    public ProjectModel(int projectId, String projectName, String projectGuide, LocalDate startDate, LocalDate endDate, int employesRequired, int duration) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectGuide = projectGuide;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employesRequired = employesRequired;
        this.duration = duration;
    }

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

    @Override
    public String toString() {
        return "ProjectModel{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectGuide='" + projectGuide + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employesRequired=" + employesRequired +
                ", duration=" + duration +
                '}';
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
