package com.example.EmployeeProjectMapping.Model;

import com.example.EmployeeProjectMapping.Entity.Project;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminModel {
    @NotNull
    private int Id;
    private String Name;
    private String Mail;
    private String Role;
    private  String password;
    private String  username;

    private List<Project> projectList=new ArrayList<>();

    public AdminModel() {
    }

    public AdminModel(int id, String name, String mail, String role) {
        Id = id;
        Name = name;
        Mail = mail;
        Role = role;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Mail='" + Mail + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
