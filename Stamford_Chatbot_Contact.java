package StamfordChatBot;
import java.util.Scanner;


public class Stamford_Chatbot_Contact {
	
	public Stamford_Chatbot_Contact(){
		Scanner input = new Scanner(System.in);
		System.out.println("CONTACT REQUEST");
		System.out.print("Department: (Admissions/IT/Finance) : ");
		String userInput = input.nextLine().toLowerCase();
		if(userInput.equals("admissions")) {
			displayAdmissions();
		}
		
		else if(userInput.equals("it")) {
			displayIT();
		}
		
		if(userInput.equals("finance")) {
			displayFinance();
		}
		
	}
	
	public void displayAdmissions() {
		System.out.println("");		
		System.out.println("*****************************");
		System.out.println("IT Helpdesk: ");
		System.out.println("✉️ admission@stamford.edu");
		System.out.println("📞 02-765-4321 (9AM-5PM)");
		System.out.println("");	
		
	}
	
	public void displayIT() {
		System.out.println("");		
		System.out.println("*****************************");
		System.out.println("IT Helpdesk: ");
		System.out.println("✉️ it-support@stamford.edu");
		System.out.println("📞 02-123-4567 (9AM-5PM)");
		System.out.println("");	
		
	}

	public void displayFinance() {
		System.out.println("");		
		System.out.println("*****************************");
		System.out.println("Finance: ");
		System.out.println("✉️ cashier_rm9@stamford.edu");
		System.out.println("📞 02-769-4000 (8:30AM-5:30PM)");
		System.out.println("");	
	
	}

}
