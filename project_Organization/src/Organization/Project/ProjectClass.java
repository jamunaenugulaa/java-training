package Organization.Project;

import Organization.Employe.EmployeClass;

import java.util.ArrayList;

public class ProjectClass{
    // adminFun admin;
     String projectName;
     int noofEmpRequired;
    int duration;
    int noofempAssigned;
    projectstatus projectStatus;
    String ProjectAdmin;
    // int requirement;


    ArrayList<EmployeClass> employeeList=new ArrayList<>();
    public ProjectClass(String name, int num, int dur){
        this.projectName=name;
        this.noofEmpRequired=num;
        this.duration=dur;
        // ProjectAdmin=Admin;
        projectStatus=projectstatus.Current;
        //  requirement=noofEmp;
        System.out.println("successfully added");
    }
    public void assignedEmploy(EmployeClass emp){
        employeeList.add(emp);
        this.noofempAssigned=noofempAssigned+1;
    }
    public void setProjectStatus(projectstatus e){
        projectStatus=e;

    }

    public void getProjectDetails(){
        System.out.println("project name: "+projectName);
        System.out.println("no of employees required for project: "+noofEmpRequired);
        System.out.println("duration required "+duration+"months");
        System.out.println("Num of Employes assigned to a project: "+noofempAssigned);
    }
    public void getAssignedEmployDetails(){
        System.out.println("The Employe Details who are worked under "+this.projectName+" project");
        for(EmployeClass emp:employeeList){
            System.out.println();
            emp.getEmployeDetails();
            System.out.println();
        }
        // System.out.println(Employees);
    }

    public void getEmployName() {
        for(EmployeClass emp:employeeList){
            System.out.println(emp.getemployeName());
        }
    }

    public projectstatus getprojectStatus() {
        return projectStatus;
    }

    public String getprojectName() {
        return projectName;
    }

    public int getnoofempAssigned() {
        return noofempAssigned;
    }

    public int getnoofEmpRequired() {
        return noofEmpRequired;
    }
}
