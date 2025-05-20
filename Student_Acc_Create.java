import java.util.Scanner;

// Base class for a User
class User {
    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Overloaded method to display basic user information
    public void displayInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

// Subclass for StudentAccount, inheriting from User
class StudentAccount extends User {
    private String studentId;
    private String password;
    private String major;

    // Constructor 1: Without major
    public StudentAccount(String userId, String name, String email, String studentId, String password) {
        super(userId, name, email); // Call the constructor of the superclass
        this.studentId = studentId;
        this.password = password;
        this.major = "Undecided"; // Default major
    }

    // Constructor 2: With major (Method Overloading)
    public StudentAccount(String userId, String name, String email, String studentId, String password, String major) {
        super(userId, name, email);
        this.studentId = studentId;
        this.password = password;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getMajor() {
        return major;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo() method of the superclass
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Email: " + email + ", Major: " + major;
    }
}

public class Student_Acc_Create {

    private static Scanner scanner = new Scanner(System.in);
    private static int nextUserIdCounter = 1; // Simple way to generate unique User IDs
    private static StudentAccount firstAccount = null; // Store the first account.

    public static void main(String[] args) {
        createAccountsRecursively(); // Start the recursive account creation process
        scanner.close(); // Close the scanner here.
    }

    private static void createAccountsRecursively() {
        System.out.println("\n--- Create Student Account ---");

        String userId = generateUniqueUserId();

        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();

        String email = getValidEmail();

        String studentId = getUniqueStudentId();

        String password = getPassword();

        System.out.print("Do you want to specify your major now? (yes/no): ");
        String specifyMajorResponse = scanner.nextLine().toLowerCase();
        StudentAccount newAccount = createNewStudentAccount(userId, name, email, studentId, password, specifyMajorResponse);

        System.out.println("Account created successfully!");
        newAccount.displayInfo(); // Using the overridden displayInfo method

        // Store the created account
        if (firstAccount == null) {
            firstAccount = newAccount;
        }

        System.out.print("Create another account? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("yes")) {
            createAccountsRecursively(); // Recursive call to create another account
        } else {
            displayAllAccounts();
        }
    }

    private static String generateUniqueUserId() {
        return "user" + nextUserIdCounter++;
    }

    private static String getValidEmail() {
        String email;
        while (true) {
            System.out.print("Enter your Email: ");
            email = scanner.nextLine();
            if (email.contains("@") && email.contains(".")) {
                return email;
            } else {
                System.out.println("Error: Invalid email format. Please try again.");
            }
        }
    }

    private static String getUniqueStudentId() {
        String studentId;
        while (true) {
            System.out.print("Enter Student ID: ");
            studentId = scanner.nextLine();
            if (!isStudentIdExists(studentId, firstAccount)) {
                return studentId;
            } else {
                System.out.println("Error: Student ID already exists. Please enter a different ID.");
            }
        }
    }

    private static String getPassword() {
        String password;
        String confirmPassword;
        while (true) {
            System.out.print("Enter your Password: ");
            password = scanner.nextLine();
            System.out.print("Confirm your Password: ");
            confirmPassword = scanner.nextLine();
            if (password.equals(confirmPassword)) {
                return password;
            } else {
                System.out.println("Error: Passwords do not match. Account creation failed.");
            }
        }
    }

    private static StudentAccount createNewStudentAccount(String userId, String name, String email, String studentId, String password, String specifyMajorResponse) {
        if (specifyMajorResponse.equals("yes")) {
            System.out.print("Enter your Major: ");
            String major = scanner.nextLine();
            return new StudentAccount(userId, name, email, studentId, password, major);
        } else {
            return new StudentAccount(userId, name, email, studentId, password);
        }
    }

    private static boolean isStudentIdExists(String studentId, StudentAccount currentAccount) {
        if (currentAccount == null) {
            return false; // No accounts exist yet.
        }
        if (currentAccount.getStudentId().equals(studentId)) {
            return true; // Found a matching Student ID.
        }
        // Without a list, we can only check against the first created account.
        return false;
    }

    private static void displayAllAccounts() {
        System.out.println("\n--- All Created Accounts ---");
        if (firstAccount == null) {
            System.out.println("No student accounts created.");
        } else {
            firstAccount.displayInfo();
            System.out.println("---");
        }
    }

    // Example of a switch statement (not directly used in account creation but demonstrating the concept)
    private static String getAcademicStanding(String major) {
        String standing;
        switch (major.toLowerCase()) {
            case "computer science":
            case "information technology":
                standing = "Good standing in the School of Computing";
                break;
            case "business administration":
            case "marketing":
                standing = "Good standing in the School of Business";
                break;
            default:
                standing = "Good academic standing";
                break;
        }
        return standing;
    }
}