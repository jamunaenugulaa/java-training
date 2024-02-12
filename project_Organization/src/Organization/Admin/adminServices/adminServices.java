package Organization.Admin.adminServices;
import Organization.Admin.AdminClass;
import Organization.Employe.EmployeClass;
import Organization.Employe.LeavesStatus;
import Organization.Project.ProjectClass;
import Organization.Project.projectstatus;
import Organization.Employe.employeServices.*;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class adminServices {
    Scanner sc = new Scanner(System.in);
    ArrayList<ProjectClass> projectList = new ArrayList<>();
    ArrayList<AdminClass> adminArrayList=new ArrayList<>();
    AdminClass admin = new AdminClass(1423, "jamuna");

    AdminClass admin2 = new AdminClass(1424, "manasa");

    ArrayList<EmployeClass> employeList = new ArrayList<>();
    HashMap<String, String> projectEmployee = new HashMap<>();
    //ArrayList<EmployeClass> employList = new ArrayList<>();
    EmployeClass e1 = new EmployeClass(1457, "lavanya", "Java Developer");
    EmployeClass e2 = new EmployeClass(1458, "deepthi", "Java Developer");
    EmployeClass e3 = new EmployeClass(1459, "shreshti", "Java Developer");
    EmployeClass e4 = new EmployeClass(1460, "sirichandana", "Java Developer");
    ProjectClass r1 = new ProjectClass("Bookstall", 2, 3);

    public adminServices() {
        employeList.add(e1);
        employeList.add(e2);
        employeList.add(e3);
        employeList.add(e4);
        projectList.add(r1);
        adminArrayList.add(admin);
        adminArrayList.add(admin2);

    }
        public void adminLogin() {
            System.out.print("Enter your Username: ");
            String user = sc.next();
            System.out.print("Enter your Password: ");
            String pass = sc.next();
            AtomicBoolean adminFound = new AtomicBoolean(false);
            adminArrayList.stream().forEach(admin -> {
                        if (admin.userName.equals(user) && pass.equals(admin.password)) {
                            //System.out.println(admin1.userName+" "+admin1.password);
                            System.out.println("\n__Login Successfully__");
                            adminFound.set(false);
                            boolean ad = true;
                            int x;
                            try {
                                while (ad) {
                                    System.out.println();
                                    System.out.println("\t\t\t_____________________________________________\n");
                                    System.out.println("1.Register for a Project\n2.Assign a Project to Employee\n3.Add Attendence\n4.Register an Employee\n5.Leave Approval\n6.view Employee based on Project\n7.view Project Details\n8.Employe Leaves in cuurent project\n10.Exit");
                                    System.out.println("\t\t\t_____________________________________________");
                                    x = sc.nextInt();
                                    switch (x) {
                                        case 1:
                                            registerProject();
                                            break;
                                        case 2:
                                            assigningProjectToEmploy();
                                            break;
                                        case 3:
                                            addAttendence();
                                            break;
                                        case 4:
                                            registerEmployes();
                                            break;
                                        case 5:
                                            leaveApproving();
                                            break;
                                        case 6:
                                            getemployDetails();
                                            break;
                                        case 7:
                                            getprojectDetails();
                                            break;
                                        case 8:
                                            leavesinCurrentProject();
                                            break;
                                        case 10:
                                            System.out.println("_________THANK YOU VISIT AGAIN________");
                                            ad = false;

                                    }

                                }
                            } catch (Exception e) {
                                System.out.println("Enter a number between 1-8 only");
                                x = sc.nextInt();

                            }

                        }

                    }
            );
            if(!adminFound.get()){
                System.out.println("Username or password Incorrect");
            }
        }
    public void registerProject() {
        System.out.println("Enter Project Name: ");
        String name = sc.next();
        System.out.println("Enter no of employees required: ");
        int num = sc.nextInt();
        System.out.println("Enter Duration in months");
        int dur = sc.nextInt();
        ProjectClass project = new ProjectClass(name, num, dur);
        projectList.add(project);
    }

    public void assigningProjectToEmploy() {
        try {
            System.out.println("enter Employe name");
            String empname = sc.next();
            System.out.println("enter project name  to assign: ");
            String pname = sc.next();
            AtomicBoolean empFound = new AtomicBoolean(false);
            AtomicBoolean projFound = new AtomicBoolean(false);
            employeList.stream().forEach(emp -> {
                        if (emp.getemployeName().equalsIgnoreCase(empname)) {
                            empFound.set(true);
                            projectList.stream().forEach(p -> {
                                if (p.getprojectName().equalsIgnoreCase(pname)) {
                                    projFound.set(true);
                                    if (p.getnoofempAssigned() < p.getnoofEmpRequired()) {
                                        p.assignedEmploy(emp);
                                        emp.assigningProject(pname, p);
                                        projectEmployee.put(empname, pname);
                                    } else {
                                        System.out.println("No more Employees is required to this project");
                                    }
                                }
                            });
                        }
                    }
            );
            if (!empFound.get()) {
                System.out.println("The employee name not exist ");
            }
            if (!projFound.get()) {
                System.out.println("the given project is not registered");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addAttendence() {
        System.out.println("Enter number of employees to give attendence: ");
        int numemp = sc.nextInt();
        for (int i = 0; i < numemp; i++) {
            System.out.println("enter employ name");
            String empName = sc.next();
            AtomicInteger attendance = new AtomicInteger();
            employeList.stream().forEach(emp -> {
                if (emp.getemployeName().equalsIgnoreCase(empName)) {
                    System.out.println("1.present\n2.absent");
                    attendance.set(sc.nextInt());
                    if (attendance.get() == 1) {
                        emp.setAttendance(true);
                    } else {
                        emp.setAttendance(false);
                    }
                    System.out.println("Attendance Added");
                }
                //return false;
            });
        }
    }

    public void registerEmployes() {
        System.out.println("Enter Employee name");
        String empName = sc.next();
        System.out.println("enter employe Id");
        int ID = sc.nextInt();
        System.out.println("enter employe role");
        String role = sc.next();
        EmployeClass employee = new EmployeClass(ID, empName, role);
        employeList.add(employee);
        System.out.println("Employee " + employee.getemployeName() + " Registered");
    }

    public void leaveApproving() {
        AtomicBoolean empFound = new AtomicBoolean(false);
    employeList.stream().forEach(emp->{
        if(emp.getLeaves()){
            empFound.set(true);
            long numOfDays = ChronoUnit.DAYS.between(emp.getStartDate(), emp.getEndDate()) + 1;
            System.out.println(emp.getemployeName()+" applied leave for "+numOfDays+"  days from "+emp.getStartDate()+" to "+emp.getEndDate());
            System.out.println("1.Approve\n2.Cancel");
            int k=sc.nextInt();
            if(k==1){
                emp.setleavestatus(LeavesStatus.Approved);
                emp.setLeaves(false);
                System.out.println("leave is Approved for "+ emp.getemployeName());
            }
            else{
                emp.setleavestatus(LeavesStatus.Cancaled);
                emp.setLeaves(false);
                emp.setsetLeaves(false);
                System.out.println("leave is not Approved for "+ emp.getemployeName());
            }
        }
    });

        if(!empFound.get()){
            System.out.println("no employes applied for Leaves");
        }
    }

    public void getemployDetails() {
        String PName;
        System.out.println("Enter project name to get details: ");
        PName = sc.next();
        projectList.stream().filter(p -> p.getprojectName().equalsIgnoreCase(PName))
                .forEach(p ->p.getEmployName());
    }

    public void getprojectDetails() {
        System.out.println("enter project name to get Details");
        String pName = sc.next();
        projectList.stream().forEach(p -> {
            if (p.getprojectName().equalsIgnoreCase(pName)) {
                p.getProjectDetails();
                System.out.println("The Employes Assigned to this project are: ");
                p.getEmployName();
            }
        });

    }

    public void leavesinCurrentProject() {
        AtomicBoolean empFound = new AtomicBoolean(false);

        projectList.stream().forEach(p -> {
            if (p.getprojectStatus().equals(projectstatus.Current)) {
                empFound.set(true);
              //  System.out.println();
                employeList.stream().filter(EmployeClass::getsetleaves)
                        .forEach(emp -> System.out.println("The current project employees who takes leaves"+emp.getemployeName()));
            }
        });
        if(!empFound.get()){
            System.out.println("No one takes leaves in this month");
        }
    }

    public void employePage() {
        employeeServices e=new employeeServices();
        e.employeeLogin(employeList);
    }
}



