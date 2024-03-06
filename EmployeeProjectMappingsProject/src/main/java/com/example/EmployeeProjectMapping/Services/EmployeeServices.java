package com.example.EmployeeProjectMapping.Services;

import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Entity.Employee;
import com.example.EmployeeProjectMapping.Entity.Project;
import com.example.EmployeeProjectMapping.Model.AddressModel;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import com.example.EmployeeProjectMapping.Model.ProjectModel;
import com.example.EmployeeProjectMapping.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private ProjectServices projectServices;

    public EmployeeModel saveEmployee(EmployeeModel employeeModel) {
        System.out.println(employeeModel);
        Employee emp=employeeRepo.findById(employeeModel.getId()).orElse(null);
        if(emp==null) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeModel, employee);
            employeeRepo.save(employee);
            return employeeModel;
        }
        return null;

    }

    public List<EmployeeModel> getEmployees() {
        List<Employee> employees=employeeRepo.findAll();
        List<EmployeeModel> employeeList=new ArrayList<>();
        employees.forEach(emp->{
            EmployeeModel employeeModel=new EmployeeModel();
            BeanUtils.copyProperties(emp,employeeModel);
            employeeList.add(employeeModel);
        });
        return employeeList;
    }

    public EmployeeModel addProject(int id, ProjectModel project) {
        Employee employee=employeeRepo.findById(id).orElse(null);
        if(employee==null){
            return null;
        }
        Project project1=new Project();
        BeanUtils.copyProperties(project,project1);
        List<Project> projectList=employee.getProjectList();
        projectList.add(project1);
        employeeRepo.save(employee);
        EmployeeModel employeeModel=new EmployeeModel();
        BeanUtils.copyProperties(employee,employeeModel);
        return employeeModel;
    }

    public void deleteEmployee(int eid, int pid) {
        Employee employee = employeeRepo.findById(eid).orElse(null);

        if (employee.getProjectList()!=null){

            employee.getProjectList().removeIf(project -> project.getProjectId()==pid);
            employeeRepo.save(employee);
            System.out.println("course Deleted");
        }
        System.out.println("course not deleted");
    }

    public EmployeeModel searchEmployee(int id) {
        Employee emp=employeeRepo.findById(id).orElse(null);
        if(emp==null){
            return null;
        }
        EmployeeModel employee=new EmployeeModel();
        BeanUtils.copyProperties(emp,employee);
        return employee;
    }

    public List<Project> getProjectList(int id) {
        Employee emp=employeeRepo.findById(id).orElse(null);
        System.out.println(emp+" "+id);
        return emp.getProjectList();
    }

    public EmployeeModel findUser(String username, String password) {
        List<Employee> employeeList=employeeRepo.findAll();
        EmployeeModel employeeModel=new EmployeeModel();
        employeeList.forEach(employee -> {
            if(employee.getUsername().equals(username)&&employee.getPassword().equals(password)){
                BeanUtils.copyProperties(employee,employeeModel);
            }
        });
        //System.out.println(employeeModel);
        if(employeeModel.getId()==0){
            return null;
        }
        return employeeModel;
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel,int eid) {
        Employee emp=employeeRepo.findById(eid).orElse(null);
        if(emp==null){
            return null;
        }
        emp.setName(employeeModel.getName());
        emp.setRole(employeeModel.getRole());
        emp.setGmail(employeeModel.getGmail());
        employeeRepo.save(emp);
        System.out.println(emp);
        return employeeModel;
    }

    public void updateAddress(AddressModel addressModel, int eid) {
        Address address=new Address(addressModel.getAddressId(), addressModel.getPincode(), addressModel.getCity());
        Employee employee=employeeRepo.findById(eid).orElse(null);
        if(employee!=null){
            employee.setAddress(address);
            employeeRepo.save(employee);
        }
    }

    public void updateUserPass(String username, String password, int eid) {
        Employee employee=employeeRepo.findById(eid).orElse(null);
        if(employee!=null){
            employee.setUsername(username);
            employee.setPassword(password);
            employeeRepo.save(employee);
            System.out.println(employee);
        }

    }
    //student.getCoursesList().removeIf(course -> course.getCourseId()==(cid));


}
