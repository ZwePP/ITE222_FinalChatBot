package StamfordChatBot;

import java.util.Scanner; // Import Scanner for user input

public class Stamford_Chatbot {
	
	public static void main(String[] args) {
		// Create a Scanner object to read user input from the console
		Scanner input = new Scanner(System.in); 
		
		// Create an instance of the chatbot system class that contains response logic
		Stamford_Chatbot_System chatBot = new Stamford_Chatbot_System(); 
		
		// Boolean flag to control the main loop
		boolean programRunning = true; 
		
		// Initial prompt for user input
		System.out.print("[main]You: ");		
		String user_input = input.nextLine().trim().toLowerCase(); // Normalize input for easier comparison
		
		// Main interaction loop - runs until user types "exit" or "6"
		while(programRunning) {
			
			// Show help menu
			if(user_input.equals("help")) {
				chatBot.Help();
			}
			
			// Show course information
			else if(user_input.equals("1") || user_input.equals("course info")) {
				chatBot.findCourse();
			}
			
			// Show academic calendar
			else if(user_input.equals("2") || user_input.equals("academic calendar")) {
				chatBot.showSchedule();
			}
			
			// Show campus map
			else if(user_input.equals("3") || user_input.equals("campus map")) {
				chatBot.showMap();
			}
			
			// Provide contact information for university staff
			else if(user_input.equals("4") || user_input.equals("contact staff")) {
				chatBot.contactStaff();
			}
			
			// Provide budget calculation assistance
			else if(user_input.equals("5") || user_input.equals("calculate budget")) {
				chatBot.showBudget();
			}
			
			// Exit the chatbot program
			else if(user_input.equals("6") || user_input.equals("exit")) {
				programRunning = false; // Change flag to stop loop
				break; // Exit the loop immediately
			}
			
			// If input doesn't match any command, show error message
			else { 
				System.out.println("");
				System.out.println("Invalid command! Please try again.");
				System.out.println("");
			}
			
			// Prompt for next input
			System.out.print("[main]You: ");
			user_input = input.nextLine().toLowerCase(); // Read and normalize next input
			System.out.println(""); // Add a blank line for spacing
		}
		
		// Display exit message
		System.out.println("Bye! See you again");
		input.close(); // Close Scanner to prevent resource leak
	}
}
