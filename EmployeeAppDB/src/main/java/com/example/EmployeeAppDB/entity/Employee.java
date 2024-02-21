package com.example.EmployeeAppDB.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
@Data
@Entity
public class Employee {
    @Id
    @Column(name="Id")
    private int employeId;

    @Column(name="Name")
    private String employeName;
    @Column(name="Age")
    private int employeAge;
    @Column(name="Role")
    private String employeRole;

    public Employee() {
    }

    public Employee(int employeId, String employeName, int employeAge, String employeRole) {
        this.employeId = employeId;
        this.employeName = employeName;
        this.employeAge = employeAge;
        this.employeRole = employeRole;
    }

    public int getEmployeAge() {
        return employeAge;
    }

    public void setEmployeAge(int employeAge) {
        this.employeAge = employeAge;
    }

    public String getEmployeName() {
        return this.employeName;
    }

    public void setEmployeName(String employeName) {
        this.employeName = employeName;
    }

    public int getEmployeId() {
        return this.employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getEmployeRole() {
        return this.employeRole;
    }

    public void setEmployeRole(String employeRole) {
        this.employeRole = employeRole;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "employeName='" + employeName + '\'' +
                ", employeId=" + employeId +
                ", employeRole='" + employeRole + '\'' +
                '}';
    }
}


