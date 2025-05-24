package StamfordChatBot;
import java.util.Scanner;

public class Stamford_Chatbot_CourseFinder {	

	
	public void findCourse() {
		System.out.println("Welcome to the Course Information System!");
        
        System.out.println("What area are you interested in?");
        System.out.println("- Computing");
        
        System.out.println("- Art");
        System.out.println("- Business");
        System.out.print("Enter your area of interest: ");
		boolean toRun = true;
		Scanner scanner = new Scanner(System.in);
		
    	String interestedArea = scanner.nextLine().trim();
    	if (interestedArea.equalsIgnoreCase("Computing")) {
            System.out.println("\nGreat! You're interested in Computing.");
            
            System.out.println("What kind of subject within Computing are you interested in?");
            
            System.out.println("- Database");
            System.out.println("- System Analysis");
            System.out.println("- Network");
            System.out.println("- Data and Algorithm");
            
            System.out.print("Enter a keyword related to the subject you like: ");
            
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();
            

            if (subjectKeywordInput.contains("database")) {
                System.out.println("\nInformation for: ITE 101 database");
                System.out.println("ITE 101: Introduction to Database Systems - Covers fundamental database concepts, relational models, and SQL.");
                
            } else if (subjectKeywordInput.contains("system analysis")) {
                System.out.println("\nInformation for: ITE 212 system analysis");
                System.out.println("ITE 212: System Analysis and Design - Focuses on methodologies and techniques for analyzing and designing information systems.");
                
            } else if (subjectKeywordInput.contains("network")) {
                System.out.println("\nInformation for: ITE 554 Network");
                System.out.println("ITE 554: Computer Networks - Explores network architectures, protocols, and security principles.");
            } else if (subjectKeywordInput.contains("data") && subjectKeywordInput.contains("algorithm"))
            {
                System.out.println("\nInformation for: ITE 221: Data and algorithm");
                System.out.println("ITE 221: Data Structures and Algorithms - Covers fundamental data structures and efficient algorithm design.");
            } else {
                System.out.println("Sorry, no matching subject found within Computing.");
            }

        } else if (interestedArea.equalsIgnoreCase("Art")) {
            System.out.println("\nGreat! You're interested in Art.");
            System.out.println("What kind of subject within Art are you interested in?");
            System.out.println("- drawing");
            System.out.println("- graphic design");
            System.out.println("- 3d animation");
            System.out.print("Enter a keyword related to the subject you like: ");
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();

            if (subjectKeywordInput.contains("drawing")) {
                System.out.println("\nInformation for: VIS 101 drawing basics");
                System.out.println("VIS 101: Basic Drawing - Introduces fundamental drawing techniques and concepts.");
            } else if (subjectKeywordInput.contains("graphic design")) {
                System.out.println("\nInformation for: GRA 201 graphic design");
                System.out.println("GRA 201: Introduction to Graphic Design - Covers principles of visual communication and design software basics.");
            } else if (subjectKeywordInput.contains("animation")) {
                System.out.println("\nInformation for: ANI 301 3d animation");
                System.out.println("ANI 301: Introduction to 3D Animation - Explores the fundamentals of 3D modeling and animation.");
            } else {
                System.out.println("Sorry, no matching subject found within Art.");
            }

        } else if (interestedArea.equalsIgnoreCase("Business")) {
            System.out.println("\nGreat! You're interested in Business.");
            System.out.println("What kind of subject within Business are you interested in?");
            System.out.println("- Marketing");
            System.out.println("- Accounting");
            System.out.println("- Management");
            System.out.print("Enter a keyword related to the subject you like: ");
            String subjectKeywordInput = scanner.nextLine().trim().toLowerCase();

            if (subjectKeywordInput.contains("marketing")) {
                System.out.println("\nInformation for: BUS 101 Marketing Principles");
                System.out.println("BUS 101: Principles of Marketing - Introduces Core Marketing Concepts and Strategies.");
            } else if (subjectKeywordInput.contains("accounting")) {
                System.out.println("\nInformation for: ACC 201 Financial accounting");
                System.out.println("ACC 201: Introduction to Financial Accounting - Covers the basics of financial statement preparation and analysis.");
            } else if (subjectKeywordInput.contains("management")) {
                System.out.println("\nInformation for: MAN 301 Management theory");
                System.out.println("MAN 301: Principles of Management - Explores fundamental management theories and practices.");
            } else {
                System.out.println("Sorry, no matching subject found within Business.");
            }

        } else {
            System.out.println("Sorry, '" + interestedArea + "' is not a recognized area.");
        }   
            
        	
        
        
        
	}
	

}
