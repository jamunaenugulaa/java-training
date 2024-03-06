package com.example.EmployeeProjectMapping.Model;

import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Entity.Project;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeModel {
    private int id;
    @NonNull
    private String name;
    private String gmail;
    private String role;
    private  String password;
    private String username;

    private Address address;
    private List<Project> projectList=new ArrayList<>();

    public EmployeeModel() {
    }

    public EmployeeModel(int id, String name, String gmail, String role, String password, String username, Address address) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.role = role;
        this.password = password;
        this.username = username;
        this.address = address;
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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", address=" + address +
                '}';
    }
}
