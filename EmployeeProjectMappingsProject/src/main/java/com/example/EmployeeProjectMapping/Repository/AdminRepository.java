package com.example.EmployeeProjectMapping.Repository;

import com.example.EmployeeProjectMapping.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
