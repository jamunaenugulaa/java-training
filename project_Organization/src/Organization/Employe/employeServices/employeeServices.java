package Organization.Employe.employeServices;

import Organization.Employe.EmployeClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class employeeServices {

    public void employeeLogin(List<EmployeClass> employList) {
        Scanner sc = new Scanner(System.in);


        String user;
        String pass;
        System.out.print("Enter your Username: ");
        user = sc.next();
        System.out.print("Enter your Password: ");
        pass = sc.next();
        AtomicBoolean choice= new AtomicBoolean(true);
        AtomicBoolean empFound = new AtomicBoolean(false);
        employList.stream().forEach(emp-> {
            if (emp.getusername().equals(user) && emp.getPassword().equals(pass)) {
                System.out.println("\n__Login Successfully__");
                empFound.set(true);
                int n;
                try {
                    while (choice.get()) {
                        System.out.println("\n\t\t\t________________________\n");
                        System.out.println("1.Get your Details\n2.Get your Project\n3.Apply for A leave\n4.get ur Leave Status\n5.Exit");
                        System.out.println("\t\t\t________________________");
                        n = sc.nextInt();
                        switch (n) {
                            case 1:
                                System.out.println("YOURS DETAILS");
                                emp.getEmployeDetails();
                                break;
                            case 2:
                                if (emp.getproject().equalsIgnoreCase("no")) {
                                    System.out.println("No projects are assigned");
                                } else {
                                    System.out.println("YOUR PROJECT DETAILS");
                                    emp.getProjectDetails();
                                }
                                break;
                            case 3:
                                boolean leave = true;
                                LocalDate startdate = null;
                                LocalDate enddate = null;
                                emp.setLeaves(leave);
                                try {
                                    System.out.println("enter start date yy-mm-dd");
                                    String start = sc.next();
                                    System.out.println("enter end date yy-mm-dd");
                                    String end = sc.next();

                                    startdate = LocalDate.parse(start, DateTimeFormatter.ISO_DATE);
                                    enddate = LocalDate.parse(end, DateTimeFormatter.ISO_DATE);
                                    emp.ApplyLeave(startdate, enddate);

                                } catch (Exception e) {
                                    System.out.println("enter correct Date format");
                                }
                                //System.out.println(enddate);


                                break;
                            case 4:
                                if (emp.getsetleaves()) {
                                    System.out.println("your Leave Status: " + emp.getLeavestatus());
                                } else {
                                    System.out.println("Your not Applied for Any Leave");
                                }
                                break;
                            case 5:
                                System.out.println("_____THANK YOU VISIT AGAIN_____");
                                choice.set(false);
                        }

                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
