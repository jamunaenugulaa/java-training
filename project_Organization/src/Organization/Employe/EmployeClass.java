package Organization.Employe;

import Organization.Project.ProjectClass;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.ArrayList;

public class EmployeClass  {
    int employeId;
     String employeName;
    String username;
    String password;
    String employeRole;
    boolean attendence;
    Boolean Leaves;
    Boolean setLeave;
    LeavesStatus leavestatus;
    LocalDate startDate;
    LocalDate endDate;

    //List<String> project=new ArrayList<>();
    String project;
    ArrayList<ProjectClass> projectsList=new ArrayList<>();
    public EmployeClass(int id, String name, String n){
        this.employeId=id;
        this.employeName=name;
        this.employeRole=n;
        username=name;
        password="12345";
        Leaves=false;
        project="no";
        setLeave=Leaves;
    }
    public void getEmployeDetails(){
        System.out.println("Employe Id: "+employeId);
        System.out.println("Employee Name: "+employeName);
        System.out.println("Employee Role: "+employeRole);
        System.out.println("projects "+project);
        System.out.println("Leavses applied: "+Leaves);
    }

    public void assigningProject(String projectName,ProjectClass proj) {
        this.project = projectName;
        projectsList.add(proj);
        System.out.println("Successfully assigned a project to " + employeName);
    }


    public void setLeaves(Boolean s){
        Leaves=s;
        if(Leaves==true){
            leavestatus=LeavesStatus.Pending;
            setLeave=true;
        }

    }
    public void setLeavestatus(LeavesStatus e){
        leavestatus=e;
    }

    public void getProjectDetails() {
        System.out.println("The "+this.project+" project Details");
        for(ProjectClass proj:projectsList){
            proj.getProjectDetails();
        }
    }

    public void ApplyLeave(LocalDate startdate, LocalDate enddate) {
        this.startDate=startdate;
        this.endDate=enddate;
        System.out.println("Successfully Applied!!");
    }

    public void setAttendance(boolean b) {
        this.attendence=b;
    }

    public boolean getLeaves() {
        return Leaves;
    }

    public String getemployeName() {
        return employeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setleavestatus(LeavesStatus leavesStatus) {
        this.leavestatus=leavesStatus;
    }

    public String getproject() {
        return project;
    }

    public String getusername() {
        return username;
    }
    public  String getPassword(){
        return password;
    }
    public LeavesStatus getLeavestatus(){
        return leavestatus;
    }

    public boolean getsetleaves() {
        return setLeave;
    }

    public void setsetLeaves(boolean b) {
        this.setLeave=b;
    }
}
