import java.util.Scanner;

public class Email {
    private String email;
    private String firstName;
    private String lastName;
    private String pass;
    private int defaultPassLength = 10;
    private String dept;
    private String altEmail;
    private String companySuffix = "google.com.au";

    //Constructor
    public Email(String fN, String lN){
        this.firstName = fN;
        this.lastName = lN;
        //System.out.println("EMAIL CREATED: " + firstName + " " + lastName);

        dept = setDept();
        //System.out.println("Selected Department: " + dept.toUpperCase());

        this.pass= randPass(defaultPassLength);
        //System.out.println("Password: " + this.pass);
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dept.toLowerCase() + "." + companySuffix;
        if(dept.length()<1){
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        }
        
        //System.out.println(email);

        System.out.println(showInfo());
    }

    //Set the department
    private String setDept(){
        System.out.println("DEPATMENT CODES: \n[1] for Sales \n[2] for Development \n[3] for Accounting \n[0] for none \nEnter Department Code:");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        if(deptChoice ==1){return "MARKETING";}
        if(deptChoice ==2){return "DEVELOPMENT";}
        if(deptChoice ==3){return "ACCOUNTING";}
        return "";
    }

    //Generate random password
    private String randPass(int length){
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int random = (int) (Math.random()*passSet.length());
            password[i]= passSet.charAt(random);
        }

        return new String(password);
    }

    //Change password
    void setPassword(String password){
        this.pass=password;
    }

    //Change alt Email
    void setAltEmail(String alt){
        this.altEmail = alt;
    }

    //getters
    public String getAltEmail(){return altEmail;}
    public String getPassword(){return this.pass;}
    public String getEmail(){return this.email;}

    public String showInfo(){
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + 
                "\nEMAIL: " + this.email +
                "\nPASSWORD: " + this.pass;
    }
}


