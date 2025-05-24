package StamfordChatBot;
import java.util.Scanner;

public class Stamford_Chatbot_CampusMap {
	
	public Stamford_Chatbot_CampusMap() {
		Scanner input = new Scanner(System.in);
		System.out.print("Where? (Library/Gym/Cafeteria): ");
		String userInput = input.nextLine().toLowerCase();
		if(userInput.equals("library")) {
			displayLibrary();
		}
		
		else if(userInput.equals("gym")) {
			displayGym();
		}
		
		if(userInput.equals("cafeteria")) {
			displayCafeteria();
		}
	}
	
	
	public void displayLibrary() {
		System.out.println("");
		System.out.println("*****************************");
		System.out.println("Library");
		System.out.println("- Building A, 1st Floor");
		System.out.println("- Open 7AM - 7PM");
		System.out.println("");
	}
	
	
	public void displayGym() {
		System.out.println("");		
		System.out.println("*****************************");
		System.out.println("- Sorry, Not Available in Rama 9 Campus");
		System.out.println("");		
	}
	
	
	public void displayCafeteria() {
		System.out.println("");		
		System.out.println("*****************************");
		System.out.println("- Building B, 1st Floor");
		System.out.println("- Open 7AM-7PM");
		System.out.println("- Today's Menu: Pad Thai, Salad");
		System.out.println("");		
	}
	
	
	

}
