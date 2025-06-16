package StamfordChatBot;

/**
 * Stamford_Chatbot_System acts as the main controller class that responds to user commands
 * and delegates functionality to other feature-specific chatbot classes.
 */
public class Stamford_Chatbot_System {

    // Instance of the course finder feature, initialized when this system is created
    Stamford_Chatbot_CourseFinder courses = new Stamford_Chatbot_CourseFinder();
	
    // Constructor - displays welcome message and basic instruction
    public Stamford_Chatbot_System() {
        System.out.println("STAMFORD CHATBOT");
        System.out.println("----------------------");
        System.out.println("Type 'help' for options");
    }
	
    // Displays a list of available chatbot commands to the user
    public void Help() {
        System.out.println("");
        System.out.println("HOW CAN I HELP?");
        System.out.println("1. Course Info");
        System.out.println("2. Academic Calendar");
        System.out.println("3. Campus Map");
        System.out.println("4. Contact Staff");
        System.out.println("5. Calculate Budget");
        System.out.println("6. Exit");	
        System.out.println("");
    }
	
    // Calls course-finding feature
    public void findCourse() {
        courses.findCourse(); // Delegates to Stamford_Chatbot_CourseFinder class
    }
	
    // Displays campus map by instantiating the CampusMap class
    public void showMap() {
        Stamford_Chatbot_CampusMap map = new Stamford_Chatbot_CampusMap();
    }
	
    // Shows contact information by instantiating the Contact class
    public void contactStaff() {
        Stamford_Chatbot_Contact contactStaff = new Stamford_Chatbot_Contact();
    }
	
    // Displays academic calendar by instantiating the Schedule class
    public void showSchedule() {
        Stamford_Chatbot_Schedule schedule = new Stamford_Chatbot_Schedule();
    }
	
    // Runs the student budget calculator by instantiating the Budget class
    public void showBudget() {
        Student_Chatbot_Budget budget = new Student_Chatbot_Budget();
    }
}
