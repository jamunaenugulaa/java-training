package Organization;
import java.util.*;

import Organization.Admin.adminServices.adminServices;

public class Main {
    public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int person;
        String user;
        String pass;
            char choice='y';
        adminServices admins=new adminServices();
        try {
            while (choice == 'y') {
                System.out.println("1.Admin\n2.User");
                person = sc.nextInt();
                switch (person) {
                    case 1:
                       admins.adminLogin();
                        break;
                    case 2:
                        admins.employePage();
                        break;
                    default:
                        System.out.println("Enter 1 or 2");
                }
                System.out.println("Do you Want to Continue?y/n");
                choice = sc.next().charAt(0);
            }
        }
        catch (Exception e){
            System.out.println("Enter 1 or 2");
        }

    }
}
