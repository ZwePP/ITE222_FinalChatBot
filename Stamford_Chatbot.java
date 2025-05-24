package StamfordChatBot;
import java.util.Scanner;

public class Stamford_Chatbot {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//Instance of Scanner Class
		Stamford_Chatbot_System chatBot = new Stamford_Chatbot_System(); //Instance of System Class

		boolean programRunning = true; //state of a program
		System.out.print("You: ");		
		String user_input = input.nextLine().trim().toLowerCase();
		
		//while loop to keep asking user input
		while(programRunning) {
			if(user_input.equals("help")) {
				chatBot.Help();
			}
	
			else if(user_input.equals("1") || user_input.equals("course info")) {
				chatBot.findCourse();
				
			}
			
			
			else if(user_input.equals("3") || user_input.equals("campus map")) {
				chatBot.showMap();
			}
			
			else if(user_input.equals("4") || user_input.equals("contact staff")) {
				chatBot.contactStaff();
			}
			
			else if(user_input.equals("5") || user_input.equals("exit")) {
				programRunning = false;
				break; // to exit while loop and leave program
			}
			
			System.out.print("You: ");
			user_input = input.nextLine().toLowerCase();
		
		}
		
		
		System.out.println("Bye! See you again");

	}

}
