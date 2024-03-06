package com.example.EmployeeProjectMapping.Services;

import com.example.EmployeeProjectMapping.Entity.Admin;
import com.example.EmployeeProjectMapping.Entity.Project;
import com.example.EmployeeProjectMapping.Model.AdminModel;
import com.example.EmployeeProjectMapping.Model.ProjectModel;
import com.example.EmployeeProjectMapping.Repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AdminServices {
    @Autowired
    private AdminRepository adminRepo;

    public AdminModel registerAdmin(AdminModel adminModel) {
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminModel,admin);
         adminRepo.save(admin);
         return adminModel;
    }

    public Boolean setUserPass(int id, String user, String pass) {
        Admin admin=adminRepo.findById(id).orElse(null);
        if(admin==null){
            return false;
        }
        admin.setUsername(user);
        admin.setPassword(pass);
        adminRepo.save(admin);
        return true;
    }

    public Boolean checkAdmin(String username, String password) {
        List<Admin> adminList=adminRepo.findAll();
        AtomicBoolean temp = new AtomicBoolean(false);
        adminList.forEach(admin -> {
                    if (admin.getUsername() != null && admin.getPassword() != null) {
                        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                            temp.set(true);
                        }
                    }
                }
        );
        if(temp.get()){
            return true;
        }
        return false;
    }

    public int findIdOfAdmin(String username, String password) {
        List<Admin> adminList=adminRepo.findAll();
        AtomicReference<Admin> admin = new AtomicReference<>(new Admin());
            adminList.forEach(a->{
                if (a.getUsername() != null && a.getPassword() != null) {

                    if(a.getUsername().equals(username)&&a.getPassword().equals(password)){
                    admin.set(a);
                }}
            });
return admin.get().getId();
    }

    public AdminModel addProject(ProjectModel projectModel,int id) {
        Admin admin=adminRepo.findById(id).orElse(null);
        if(admin==null){
            return null;
        }
        List<Project> projectList=admin.getProjectList();
        Project project=new Project();
        BeanUtils.copyProperties(projectModel,project);
        projectList.add(project);
        admin.setProjectList(projectList);
        adminRepo.save(admin);
        AdminModel adminModel=new AdminModel();
        BeanUtils.copyProperties(admin,adminModel);
        return adminModel;
    }

    public AdminModel getAdminById(int id) {
        Admin admin=adminRepo.findById(id).orElse(null);
        AdminModel adminModel=new AdminModel();
        BeanUtils.copyProperties(admin,adminModel);
        return adminModel;
    }


    public List<ProjectModel> getProjectList(int id) {
        Admin admin=adminRepo.findById(id).orElse(null);
        List<Project> projectList=admin.getProjectList();
        List<ProjectModel> projectModels=new ArrayList<>();
        if(admin!=null){
            projectList.forEach(project -> {
                ProjectModel pm=new ProjectModel();
                BeanUtils.copyProperties(project,pm);
                projectModels.add(pm);
            });
        }
        return projectModels;
    }
}
