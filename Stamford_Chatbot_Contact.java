package StamfordChatBot;

import java.util.Scanner;

public class Stamford_Chatbot_Contact {

    // Constructor: prompts the user to enter a department and shows contact info
    public Stamford_Chatbot_Contact() {
        Scanner input = new Scanner(System.in);

        // Prompt user for department selection
        System.out.println("CONTACT REQUEST");
        System.out.print("Department: (Admissions/IT/Finance) : ");
        String userInput = input.nextLine().toLowerCase(); // Convert input to lowercase for easier matching

        // Check user input and call corresponding method
        if (userInput.equals("admissions")) {
            displayAdmissions();
        } else if (userInput.equals("it")) {
            displayIT();
        }

        // This condition should be "else if" to avoid duplicate calls
        if (userInput.equals("finance")) {
            displayFinance();
        }
    }

    // Display contact info for Admissions
    public void displayAdmissions() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("IT Helpdesk: ");
        System.out.println("✉️ admission@stamford.edu");
        System.out.println("📞 02-765-4321 (9AM-5PM)");
        System.out.println("");
    }

    // Display contact info for IT department
    public void displayIT() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("IT Helpdesk: ");
        System.out.println("✉️ it-support@stamford.edu");
        System.out.println("📞 02-123-4567 (9AM-5PM)");
        System.out.println("");
    }

    // Display contact info for Finance department
    public void displayFinance() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("Finance: ");
        System.out.println("✉️ cashier_rm9@stamford.edu");
        System.out.println("📞 02-769-4000 (8:30AM-5:30PM)");
        System.out.println("");
    }
}
