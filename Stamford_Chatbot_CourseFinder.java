package StamfordChatBot;

import java.util.Scanner;

public class Stamford_Chatbot_CourseFinder {

    // Main method to find course based on user interest and keyword
    public void findCourse() {
        System.out.println("Welcome to the Course Information System!");
        System.out.println("What area are you interested in?");
        System.out.println("1. Computing");
        System.out.println("2. Art");
        System.out.println("3. Business");
        System.out.print("Enter your area of interest: ");

        boolean toRun = true;
        Scanner scanner = new Scanner(System.in);

        // Get the user's selected area of interest
        String interestedArea = scanner.nextLine().trim();

        // If user selects Computing
        if (interestedArea.equalsIgnoreCase("Computing") || interestedArea.equals("1")) {
            System.out.println("\nGreat! You're interested in Computing.");
            System.out.println("What kind of subject within Computing are you interested in?");
            System.out.println("");
            System.out.println("1. Database");
            System.out.println("2. System Analysis");
            System.out.println("3. Network");
            System.out.println("4. Data and Algorithm");
            System.out.println("");
            System.out.print("Enter a keyword related to the subject you like: ");

            // Get keyword for subject
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();

            // Check user input and display related Computing course info
            if (subjectKeywordInput.contains("database") || subjectKeywordInput.equals("1")) {
                System.out.println("\nInformation for: ITE 101 database");
                System.out.println("ITE 101: Introduction to Database Systems - Covers fundamental database concepts, relational models, and SQL.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("system analysis") || subjectKeywordInput.equals("2")) {
                System.out.println("\nInformation for: ITE 212 system analysis");
                System.out.println("ITE 212: System Analysis and Design - Focuses on methodologies and techniques for analyzing and designing information systems.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("network") || subjectKeywordInput.equals("3")) {
                System.out.println("\nInformation for: ITE 554 Network");
                System.out.println("ITE 554: Computer Networks - Explores network architectures, protocols, and security principles.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("data") && subjectKeywordInput.contains("algorithm") || subjectKeywordInput.equals("4")) {
                System.out.println("\nInformation for: ITE 221: Data and algorithm");
                System.out.println("ITE 221: Data Structures and Algorithms - Covers fundamental data structures and efficient algorithm design.");
                System.out.println("");
            } else {
                System.out.println("Sorry, no matching subject found within Computing.");
                System.out.println("");
            }

        // If user selects Art
        } else if (interestedArea.equalsIgnoreCase("Art") || interestedArea.equals("2")) {
            System.out.println("\nGreat! You're interested in Art.");
            System.out.println("What kind of subject within Art are you interested in?");
            System.out.println("1. Drawing");
            System.out.println("2. Graphic Design");
            System.out.println("3. 3D Animation");
            System.out.println("");
            System.out.print("Enter a keyword related to the subject you like: ");

            // Get keyword for subject
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();

            // Check user input and display related Art course info
            if (subjectKeywordInput.contains("drawing") || subjectKeywordInput.equals("1")) {
                System.out.println("\nInformation for: VIS 101 drawing basics");
                System.out.println("VIS 101: Basic Drawing - Introduces fundamental drawing techniques and concepts.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("graphic design") || subjectKeywordInput.equals("2")) {
                System.out.println("\nInformation for: GRA 201 graphic design");
                System.out.println("GRA 201: Introduction to Graphic Design - Covers principles of visual communication and design software basics.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("animation") || subjectKeywordInput.equals("3")) {
                System.out.println("\nInformation for: ANI 301 3D animation");
                System.out.println("ANI 301: Introduction to 3D Animation - Explores the fundamentals of 3D modeling and animation.");
                System.out.println("");
            } else {
                System.out.println("Sorry, no matching subject found within Art.");
                System.out.println("");
            }

        // If user selects Business
        } else if (interestedArea.equalsIgnoreCase("Business") || interestedArea.equals("3")) {
            System.out.println("\nGreat! You're interested in Business.");
            System.out.println("What kind of subject within Business are you interested in?");
            System.out.println("1. Marketing");
            System.out.println("2. Accounting");
            System.out.println("3. Management");
            System.out.println("");
            System.out.print("Enter a keyword related to the subject you like: ");

            // Get keyword for subject
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();

            // Check user input and display related Business course info
            if (subjectKeywordInput.contains("marketing") || subjectKeywordInput.equals("1")) {
                System.out.println("\nInformation for: BUS 101 Marketing Principles");
                System.out.println("BUS 101: Principles of Marketing - Introduces Core Marketing Concepts and Strategies.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("accounting") || subjectKeywordInput.equals("2")) {
                System.out.println("\nInformation for: ACC 201 Financial accounting");
                System.out.println("ACC 201: Introduction to Financial Accounting - Covers the basics of financial statement preparation and analysis.");
                System.out.println("");
            } else if (subjectKeywordInput.contains("management") || subjectKeywordInput.equals("3")) {
                System.out.println("\nInformation for: MAN 301 Management theory");
                System.out.println("MAN 301: Principles of Management - Explores fundamental management theories and practices.");
                System.out.println("");
            } else {
                System.out.println("Sorry, no matching subject found within Business.");
                System.out.println("");
            }

        // If user enters an unrecognized area
        } else {
            System.out.println("Sorry, '" + interestedArea + "' is not a recognized area.");
        }
    }
}
