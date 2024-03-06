package com.example.EmployeeProjectMapping.Repository;

import com.example.EmployeeProjectMapping.Entity.Employee;
import com.example.EmployeeProjectMapping.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
