public class Email {
    private String email;
    private String firstName;
    private String lastName;
    private String pass;
    private int defaultPassLength = 10;
    private String dept;
    private String altEmail;
    private String companySuffix = "google.com.au";

    // Constructor
    public Email(String fN, String lN, int deptChoice) {
        this.firstName = fN;
        this.lastName = lN;

        this.dept = setDept(deptChoice);
        this.pass = randPass(defaultPassLength);

        if (dept.isEmpty()) {
            this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dept.toLowerCase() + "." + companySuffix;
        }
    }

    private String setDept(int deptChoice) {
        return switch (deptChoice) {
            case 1 -> "MARKETING";
            case 2 -> "DEVELOPMENT";
            case 3 -> "ACCOUNTING";
            default -> "";
        };
    }

    private String randPass(int length) {
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passSet.length());
            password[i] = passSet.charAt(random);
        }
        return new String(password);
    }

    // Optional setters
    public void setPassword(String password) {
        this.pass = password;
    }

    public void setAltEmail(String alt) {
        this.altEmail = alt;
    }

    // Getters
    public String getAltEmail() {
        return altEmail;
    }

    public String getPassword() {
        return this.pass;
    }

    public String getEmail() {
        return this.email;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
                "\nEMAIL: " + this.email +
                "\nPASSWORD: " + this.pass;
    }
}
