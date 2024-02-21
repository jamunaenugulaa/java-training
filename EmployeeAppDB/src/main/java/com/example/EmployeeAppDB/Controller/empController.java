package com.example.EmployeeAppDB.Controller;

import com.example.EmployeeAppDB.Service.empService;
import com.example.EmployeeAppDB.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;

@Controller
public class empController{
        @Autowired
        private empService service;
        @RequestMapping("/home")
        public String home(){
            return ("home");
        }
        @RequestMapping("/formFilling")
        public String addEmploye(){
             return "addEmployeeForm";
        }
        @RequestMapping("/addEmployee")
        public String addingEmploye(Employee emp, ModelMap mp){
            Employee employee=service.saveEmployee(emp);
            mp.addAttribute("employee",employee);
             return "addResult";
        }
        @RequestMapping("/viewEmploys")
        public String viewEmployes(ModelMap mp){
            List<Employee> empl=service.getEmployes();
            System.out.println(empl);
            mp.addAttribute("empList",empl);
            return "viewEmploys";
        }
        @RequestMapping("/searchEmploye")
    public String searchEmploye(){
            return "searchEmploye";
        }
    @RequestMapping("/searchResults")
    public String searchResults(@RequestParam("employeId") int id,ModelMap mp){
            Employee employe=service.getEmployeById(id);
            mp.addAttribute("emp",employe);
            return "searchResults";
    }
    @RequestMapping("/updateEmploye")
    public String updateEmploye(){
            return "updateEmploye";
    }
    @RequestMapping("/updateFormEmp")
    public String updateFormEmp(@RequestParam("employeId") int id,ModelMap mp){
        Employee employe=service.getEmployeById(id);
        mp.addAttribute("emp",employe);
        return "updateFormEmp";
    }
    @RequestMapping("/updateResult")
    public String updateResult(Employee emp,ModelMap mp){
            Employee employe=service.updateEmploye(emp);
            mp.addAttribute("employe",employe);
            return "updateResult";
    }
    @RequestMapping("deleteEmploye")
    public  String deleteEmploye(){
            return "deleteEmploye";
    }
    @RequestMapping("/deleteResult")
    public String deleteResult(@RequestParam("employeId") int id,ModelMap mp){
        Employee employe=service.deleteEmploye(id);
                mp.addAttribute("emp",employe);
        return "deleteResults";
    }
}
