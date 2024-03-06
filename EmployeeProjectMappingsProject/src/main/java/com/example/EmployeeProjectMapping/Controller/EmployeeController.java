package com.example.EmployeeProjectMapping.Controller;

import com.example.EmployeeProjectMapping.Entity.Address;
import com.example.EmployeeProjectMapping.Entity.Employee;
import com.example.EmployeeProjectMapping.Entity.Project;
import com.example.EmployeeProjectMapping.Model.AddressModel;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import com.example.EmployeeProjectMapping.Model.ProjectModel;
import com.example.EmployeeProjectMapping.Services.AdminServices;
import com.example.EmployeeProjectMapping.Services.EmployeeServices;
import com.example.EmployeeProjectMapping.Services.ProjectServices;
import com.example.EmployeeProjectMapping.Validation.EmployeeAddressValidation;
import com.example.EmployeeProjectMapping.Validation.employeeDetailsValidation;
import com.example.EmployeeProjectMapping.Validation.employeeValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private AdminServices adminServices;
    @Autowired
    private ProjectServices projectServices;
    @Autowired
    private EmployeeServices employeeServices;
    int eid;
    String username;
    String password;
@Autowired
employeeValidation valid;
@Autowired
employeeDetailsValidation DetailsValid;
@Autowired
EmployeeAddressValidation AddressValid;
    @RequestMapping("/User")
    public String User(ModelMap map){
        EmployeeModel employeeModel=new EmployeeModel();
        map.addAttribute("employeeModel",employeeModel);
        return "employeeLogin";
    }
    @RequestMapping("/checkUserLogin")
    public String checkUserLogin(@Valid @ModelAttribute("employeeModel") EmployeeModel employeeModel, BindingResult bindingResult, ModelMap map){
        valid.validate(employeeModel,bindingResult);
        if(bindingResult.hasErrors()){
            //System.out.println(bindingResult.getAllErrors());
            return "employeeLogin";
        }
        username=employeeModel.getUsername();
        password=employeeModel.getPassword();
        EmployeeModel employee=employeeServices.findUser(username,password);
        if(employee==null){
            map.addAttribute("msg","Enter Valid Username or Password");
            return "employeeLogin";
        }
        eid= employee.getId();
        return "employeeView";
    }
    @RequestMapping("GetEmployeeDetails")
    public String GetEmployeeDetails(ModelMap map){
        System.out.println("employeeid"+eid);
        EmployeeModel emp=employeeServices.searchEmployee(eid);
        map.addAttribute("employee",emp);
        return "GetEmployeeDetails";
    }
    @RequestMapping("/GetProjectsOfEmployee")
    public String GetProjectsOfEmployee(ModelMap map){
        List<Project> projectList=employeeServices.getProjectList(eid);
        map.addAttribute("projectList",projectList);
            return "GetProjectsOfEmployee";
    }
    @RequestMapping("/updateEmployeeForm")
    public String updateEmployeeForm(ModelMap map){
        EmployeeModel employeeModel=new EmployeeModel();
        map.addAttribute("employeeModel",employeeModel);
        map.addAttribute("eid",eid);
        return "updateEmployeeForm";
    }
    @RequestMapping("/updateEmployeeDetailsDone")
    public String updateEmployeeDetailsDone(@Valid @ModelAttribute("employeeModel") EmployeeModel employeeModel, BindingResult bindingResult,ModelMap map){
        System.out.println(employeeModel);
        DetailsValid.validate(employeeModel,bindingResult);
    if(bindingResult.hasErrors()){
        map.addAttribute("eid",eid);

        System.out.println(bindingResult.getAllErrors());
        return "updateEmployeeForm";
    }
   // EmployeeModel employeeModel1=employeeServices.updateEmployee(employeeModel,eid);
    return "redirect:GetEmployeeDetails";
    }

    @RequestMapping("/updateEmployeeAddressForm")
    public String updateEmployeeAddressForm(ModelMap map){
//        EmployeeModel employeeModel=new EmployeeModel();
//        map.addAttribute("employeeModel",employeeModel);
//        map.addAttribute("eid",eid);
        map.addAttribute("addressModel",new AddressModel());
        return "updateEmployeeAddressForm";
    }
    @RequestMapping("/updateEmployeeAddresssDone")
    public String updateEmployeeAddresssDone(@Valid @ModelAttribute("addressModel") AddressModel addressModel,BindingResult bindingResult,ModelMap map){
        System.out.println(addressModel);
     AddressValid.validate(addressModel,bindingResult);
     if(bindingResult.hasErrors()){
         System.out.println(bindingResult.getAllErrors());
         return "updateEmployeeAddressForm";
     }
        employeeServices.updateAddress(addressModel,eid);
        return "redirect:GetEmployeeDetails";
    }
    @RequestMapping("/updateUsernameAndPassword")
    public String updateUsernameAndPassword(ModelMap map){
        map.addAttribute("employeeModel",new EmployeeModel());
        return "updateUsernameAndPassword";
    }
    @RequestMapping("updateUsernamePasswordDone")
    public String updateUsernamePasswordDone(@Valid @ModelAttribute("employeeModel") EmployeeModel employeeModel, BindingResult bindingResult){
        valid.validate(employeeModel,bindingResult);
        if(bindingResult.hasErrors()) {
            return "updateUsernameAndPassword";

        }
        System.out.println("eid"+eid);
        employeeServices.updateUserPass(employeeModel.getUsername(),employeeModel.getPassword(),eid);
        return "employeeView";

    }
   }
