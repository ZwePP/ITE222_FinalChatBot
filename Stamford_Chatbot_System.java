package StamfordChatBot;


public class Stamford_Chatbot_System {
	Stamford_Chatbot_CourseFinder courses = new Stamford_Chatbot_CourseFinder();
	
	public Stamford_Chatbot_System(){
		System.out.println("STAMFORD CHATBOT");
		System.out.println("----------------------");
		System.out.println("Type 'help' for options");
	}
	
	
	public void Help() {
		System.out.println("");
		System.out.println("HOW CAN I HELP?");
		System.out.println("1. Course Info");
		System.out.println("2. Exam Schedule");
		System.out.println("3. Campus Map");
		System.out.println("4. Contact Staff");
		System.out.println("5. Exit");	
		System.out.println("");
	}
	
	public void findCourse() {
		courses.findCourse();
	}
	
	public void showMap() {
		Stamford_Chatbot_CampusMap map = new Stamford_Chatbot_CampusMap();
	}
	
	public void contactStaff() {
		Stamford_Chatbot_Contact contactStaff = new Stamford_Chatbot_Contact ();
	}
	
	
	

}

		

