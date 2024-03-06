package com.example.EmployeeProjectMapping.Services;

import com.example.EmployeeProjectMapping.Entity.Employee;
import com.example.EmployeeProjectMapping.Entity.Project;
import com.example.EmployeeProjectMapping.Model.EmployeeModel;
import com.example.EmployeeProjectMapping.Model.ProjectModel;
import com.example.EmployeeProjectMapping.Repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServices {
    @Autowired
    private ProjectRepository projectRepo;
    public ProjectModel saveProject(ProjectModel projectModel) {
        Project project=new Project();
        BeanUtils.copyProperties(projectModel,project);
        projectRepo.save(project);
        return projectModel;
    }

    public List<EmployeeModel> getEmployees(int pid) {
        Project project=projectRepo.findById(pid).orElse(null);
        List<Employee> employeeList=project.getEmployeeList();
        List<EmployeeModel> employeeModelList=new ArrayList<>();
        System.out.println(employeeList.size());
        employeeList.forEach(emp->{
            EmployeeModel model=new EmployeeModel();
            BeanUtils.copyProperties(emp,model);
            employeeModelList.add(model);
        });
        return employeeModelList;
    }

    public ProjectModel getProject(int pid) {
        Project project=projectRepo.findById(pid).orElse(null);
        ProjectModel projectModel=projectEntityToModel(project);
        return projectModel;
    }

    private ProjectModel projectEntityToModel(Project project) {
        ProjectModel model=new ProjectModel();
        model.setProjectId(project.getProjectId());
        model.setProjectName(project.getProjectName());
        model.setProjectGuide(project.getProjectGuide());
        model.setDuration(project.getDuration());
        model.setEmployesRequired(project.getDuration());
        model.setAdmin(project.getAdmin());
        model.setStartDate(project.getStartDate());
        model.setEndDate(project.getEndDate());
        model.setEmployeeList(project.getEmployeeList());
        return model;
    }
    private Project projectModelToEntity(ProjectModel project) {
        Project model=new Project();
        model.setProjectId(project.getProjectId());
        model.setProjectName(project.getProjectName());
        model.setProjectGuide(project.getProjectGuide());
        model.setDuration(project.getDuration());
        model.setEmployesRequired(project.getDuration());
        model.setAdmin(project.getAdmin());
        model.setStartDate(project.getStartDate());
        model.setEndDate(project.getEndDate());
        model.setEmployeeList(project.getEmployeeList());
        return model;
    }


    public ProjectModel setEmpCountDecrease(int pid) {
        Project project=projectRepo.findById(pid).orElse(null);
        int count=project.getEmployesRequired();
        count--;
        System.out.println("count decreasesd"+count);
        project.setEmployesRequired(count);
        projectRepo.save(project);
        ProjectModel model=new ProjectModel();
        BeanUtils.copyProperties(project,model);
        return model;
    }

    public ProjectModel setEmpCountIncrease(int pid) {
        Project project=projectRepo.findById(pid).orElse(null);
        int count=project.getEmployesRequired();
        count++;
        System.out.println("count Increasesd"+count);
        project.setEmployesRequired(count);
        projectRepo.save(project);
        ProjectModel model=new ProjectModel();
        BeanUtils.copyProperties(project,model);
        return model;
    }
}
