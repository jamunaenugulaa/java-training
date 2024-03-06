package com.example.EmployeeProjectMapping.Controller;

import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Entity.Employee;
import com.example.EmployeeProjectMapping.Entity.Project;
import com.example.EmployeeProjectMapping.Model.AdminModel;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import com.example.EmployeeProjectMapping.Model.ProjectModel;
import com.example.EmployeeProjectMapping.Services.AdminServices;
import com.example.EmployeeProjectMapping.Services.EmployeeServices;
import com.example.EmployeeProjectMapping.Services.ProjectServices;
import com.example.EmployeeProjectMapping.Validation.NewValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class BaseController {
    @Autowired
    private AdminServices adminServices;
    @Autowired
    private ProjectServices projectServices;
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    NewValidation valid;
    int id;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/Admin")
    public String Admin(){
        return "AdminLogin";
    }
    @RequestMapping("/RegisterAdmin")
    public String RegisterAdmin(ModelMap model){
        AdminModel adminModel=new AdminModel();
        model.addAttribute("adminModel",adminModel);
        return "RegisterAnAdmin";
    }
    @RequestMapping("/registerEmployee")
    public  String registerEmployee(@Valid @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, ModelMap mp){
        valid.validate(adminModel,bindingResult);
       // System.out.println(bindingResult.getAllErrors());
        if(bindingResult.hasErrors()){
           System.out.println(bindingResult.getAllErrors());
            return "RegisterAnAdmin";
        }
        AdminModel admin=adminServices.registerAdmin(adminModel);
        id= adminModel.getId();
        mp.addAttribute("id",adminModel.getId());
        mp.addAttribute("adminModel",adminModel);
        return "setUserPass";
    }
    @RequestMapping("/setUserPass")
    public String setUserPass(@Valid @ModelAttribute("adminModel") AdminModel adminModel,BindingResult bindingResult){
        valid.validate1(adminModel,bindingResult);
        if(bindingResult.hasErrors()){
            //    System.out.println(bindingResult.getAllErrors());
            return "setUserPass";
        }

        Boolean set=adminServices.setUserPass(id,adminModel.getUsername(),adminModel.getPassword());

        System.out.println(id);
        return "adminView";
    }
    @RequestMapping("/LoginAdmin")
    public String LoginAdmin(){
    return "LoginPage";
    }
    @RequestMapping("/checkLoginPage")
    public String checkLoginPage(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap mp){
        Boolean check=adminServices.checkAdmin(username,password);
        if(check){
             id=adminServices.findIdOfAdmin(username,password);
            System.out.println(id);
            mp.addAttribute("id",id);
            return "adminView";
        }
        else{
            mp.addAttribute("msg","Username or Password Incorrect");
            return "LoginPage";
        }
    }
    @RequestMapping("/RegisterProject")
    public String registerProject(ModelMap mp){
        System.out.println(id);
        mp.addAttribute("id",id);
        return "RegisterProject";
    }
    @RequestMapping("/RegisterProjectDone")
    public String RegisterProjectDone(ProjectModel projectModel){

        ProjectModel project2=projectServices.saveProject(projectModel);
        System.out.println(project2);
       //AdminModel admin=adminServices.getAdminById(id);
        AdminModel admin=adminServices.addProject(projectModel,id);
        System.out.println(admin.getProjectList().size());

        return "redirect:viewProjects";
    }
    @RequestMapping("/viewProjects")
    public String viewProjects(ModelMap map){
        AdminModel admin=adminServices.getAdminById(id);
        List<ProjectModel> adminModelList=adminServices.getProjectList(id);
        //System.out.println(adminModelList);
        map.addAttribute("projectList",adminModelList);
        return "viewProjects";
    }
    @RequestMapping("/RegisterEmployee")
    public String RegisterEmployee(){
        return "RegisterEmployeeForm";
    }
    @RequestMapping("/RegisterEmployeeDone")
    public String RegisterEmployeeDone(int id,String name,String gmail,String role,String username,String password,int addressId,int pincode,String city,ModelMap map){
        Address address=new Address(addressId,pincode,city);
        EmployeeModel emp=new EmployeeModel(id,name,gmail,role,password,username,address);
        EmployeeModel emp1=employeeServices.saveEmployee(emp);
        return "redirect:viewEmployes";
    }
    @RequestMapping("/viewEmployes")
    public String viewEmployes(ModelMap mp){
        List<EmployeeModel> employeeList=employeeServices.getEmployees();
        mp.addAttribute("employeeList",employeeList);
        return "viewEmployees";
    }
    @RequestMapping("/adminView")
    public String adminView(){
        return "adminView";
    }
    @RequestMapping("/assignProjectToEmploye")
    public String assignProjectToEmploye(int pid,ModelMap mp){
        mp.addAttribute("pid",pid);
        return "assignProjectToEmployeForm";
    }
    @RequestMapping("/viewEmployeOfProject")
    public String viewEmployeOfProject(int pid,ModelMap map){
        List<EmployeeModel> employeeModelList=projectServices.getEmployees(pid);
        map.addAttribute("employeeList",employeeModelList);
        map.addAttribute("pid",pid);
        return "viewEmployeOfProject";
    }
    @RequestMapping("/assignProjectToEmployeeDone")
    public String assignProjectToEmployeeDone(int pid,int id,ModelMap mp){
        ProjectModel project=projectServices.getProject(pid);
        int emp= project.getEmployesRequired();
        System.out.println("before:"+emp);
        if(emp<=0){
            mp.addAttribute("msg","Employees Not Required For This Project");
            mp.addAttribute("pid",pid);
            return "assignProjectToEmployeForm";

        }
        EmployeeModel employeeModel=employeeServices.searchEmployee(id);
        System.out.println(employeeModel);

        if(employeeModel==null) {
            mp.addAttribute("msg","Employee Not Registered");
            mp.addAttribute("pid",pid);

            return "assignProjectToEmployeForm";
        }
        ProjectModel model=projectServices.setEmpCountDecrease(pid);
        employeeServices.addProject(id,model);
        mp.addAttribute("pid",pid);
        return "redirect:viewProjects";
    }
    @RequestMapping("/DeleteEmployeOfProject")
    public String DeleteEmployeOfProject(int eid,int pid){
        ProjectModel model=projectServices.setEmpCountIncrease(pid);
        ProjectModel project=projectServices.getProject(pid);
        employeeServices.deleteEmployee(eid,pid);
        return "redirect:viewProjects";

    }
    @RequestMapping("/viewProjectOfEmployee")
    public String viewProjectOfEmployee(int eid,ModelMap map){
        List<Project> projectModels=employeeServices.getProjectList(eid);
        map.addAttribute("projectList",projectModels);
        map.addAttribute("id",eid);
        return "viewProjectOfEmployee";
    }
    @RequestMapping("/deleteProjectOfEmploye")
    public String deleteProjectOfEmploye(int eid,int pid){
        ProjectModel model=projectServices.setEmpCountIncrease(pid);
        ProjectModel project=projectServices.getProject(pid);
        employeeServices.deleteEmployee(eid,pid);
        return "redirect:viewEmployes";

    }




}
