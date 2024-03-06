package com.example.EmployeeProjectMapping.Repository;

import com.example.EmployeeProjectMapping.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
