package com.example.EmployeeAppDB.Service;

import com.example.EmployeeAppDB.Repository.empRepo;
import com.example.EmployeeAppDB.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class empService {
    @Autowired
    private empRepo repo;

    public Employee saveEmployee(Employee employee) {
        Optional<Employee> emp=repo.findById(employee.getEmployeId());
        if(emp.isEmpty()){
            return repo.save(employee);
        }
        return null;
    }

    public List<Employee> getEmployes() {
        return repo.findAll();
    }

    public Employee getEmployeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Employee updateEmploye(Employee employe) {
//        Employee emp=repo.findById(employe.getEmployeId()).orElse(null);
//        emp.setEmployeAge(employe.getEmployeAge());
//        emp.setEmployeName(employe.getEmployeName());
//        emp.setEmployeRole(employe.getEmployeRole());
        return repo.save(employe);


    }

    public Employee deleteEmploye(int id) {
        Employee emp=repo.findById(id).orElse(null);
        if(emp==null){
            return null;
        }
        else{
            repo.deleteById(id);
            return emp;
        }


    }
}
