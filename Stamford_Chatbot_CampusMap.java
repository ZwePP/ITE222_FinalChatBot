package StamfordChatBot;

import java.util.Scanner;

public class Stamford_Chatbot_CampusMap {

    // Constructor: asks the user for a location and displays its details
    public Stamford_Chatbot_CampusMap() {
        Scanner input = new Scanner(System.in);

        // Prompt user for desired campus location
        System.out.print("Where? (Library/Gym/Cafeteria): ");
        String userInput = input.nextLine().toLowerCase(); // Convert input to lowercase for comparison

        // Check if the input is "library" and display library info
        if (userInput.equals("library")) {
            displayLibrary();
        }

        // Check if the input is "gym" and display gym info
        else if (userInput.equals("gym")) {
            displayGym();
        }

        // This condition should be 'else if' to avoid unnecessary calls when input is ambiguous
        if (userInput.equals("cafeteria")) {
            displayCafeteria();
        }
    }

    // Displays library location and operating hours
    public void displayLibrary() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("Library");
        System.out.println("- Building A, 1st Floor");
        System.out.println("- Open 7AM - 7PM");
        System.out.println("");
    }

    // Displays gym availability message
    public void displayGym() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("- Sorry, Not Available in Rama 9 Campus");
        System.out.println("");
    }

    // Displays cafeteria location, hours, and today's menu
    public void displayCafeteria() {
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("- Building B, 1st Floor");
        System.out.println("- Open 7AM-7PM");
        System.out.println("- Today's Menu: Pad Thai, Salad");
        System.out.println("");
    }

}
