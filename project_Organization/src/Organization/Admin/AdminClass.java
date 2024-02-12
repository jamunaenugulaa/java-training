package Organization.Admin;

public class AdminClass {
    int adminId;
    String adminName;
    public String userName;
    public String password;
    public AdminClass(int id, String Name){
        this.adminId=id;
        this.adminName=Name;
        userName=Name;//+"@cjsstechnologies.com";
        password="cjss@123";

    }
    public void setPassword(String str){

        password=str;
    }
}
