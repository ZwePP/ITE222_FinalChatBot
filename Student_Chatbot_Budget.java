package StamfordChatBot;

import java.util.Scanner; // Import Scanner for reading user input

/**
 * The Student_Chatbot_Budget class provides an interactive console-based budget calculator
 * for students to estimate their expenses and calculate their remaining budget.
 */
public class Student_Chatbot_Budget {
    
    // Constructor that runs the budget calculator upon object creation
	public Student_Chatbot_Budget() {
		Scanner scanner = new Scanner(System.in); // Create Scanner instance to capture user input

        System.out.println("--- Student Budget Calculator ---");

        // Prompt user for total income
        System.out.print("Enter your total income for the period: $");
        double income = scanner.nextDouble();

        // Create an instance of the calculator using the provided income
        StudentBudgetCalculator calculator = new StudentBudgetCalculator(income);

        // Gather various expense inputs from the user
        System.out.print("Enter your tuition fees: $");
        calculator.setTuitionFees(scanner.nextDouble());

        System.out.print("Enter your accommodation costs: $");
        calculator.setAccommodation(scanner.nextDouble());

        System.out.print("Enter your estimated food costs: $");
        calculator.setFood(scanner.nextDouble());

        System.out.print("Enter your estimated transportation costs: $");
        calculator.setTransportation(scanner.nextDouble());

        System.out.print("Enter your estimated personal expenses: $");
        calculator.setPersonalExpenses(scanner.nextDouble());

        System.out.print("Enter any other expenses: $");
        calculator.setOtherExpenses(scanner.nextDouble());

        // Display a summary of income, expenses, and remaining budget
        calculator.displayBudgetSummary();
	}

    /**
     * Inner static class representing the budget calculator logic.
     * Handles storage of financial data, calculation, and summary display.
     */
    public static class StudentBudgetCalculator {
        // Instance variables to store income and different types of expenses
        private double income;
        private double tuitionFees;
        private double accommodation;
        private double food;
        private double transportation;
        private double personalExpenses;
        private double otherExpenses;

        // Constructor initializes income and sets default values for all expenses
        public StudentBudgetCalculator(double income) {
            this.income = income;
            this.tuitionFees = 0;
            this.accommodation = 0;
            this.food = 0;
            this.transportation = 0;
            this.personalExpenses = 0;
            this.otherExpenses = 0;
        }

        // Setters for each expense category
        public void setTuitionFees(double tuitionFees) {
            this.tuitionFees = tuitionFees;
        }

        public void setAccommodation(double accommodation) {
            this.accommodation = accommodation;
        }

        public void setFood(double food) {
            this.food = food;
        }

        public void setTransportation(double transportation) {
            this.transportation = transportation;
        }

        public void setPersonalExpenses(double personalExpenses) {
            this.personalExpenses = personalExpenses;
        }

        public void setOtherExpenses(double otherExpenses) {
            this.otherExpenses = otherExpenses;
        }

        // Calculate the remaining budget by subtracting total expenses from income
        public double calculateRemainingBudget() {
            double totalExpenses = tuitionFees + accommodation + food + transportation + personalExpenses + otherExpenses;
            return income - totalExpenses;
        }

        // Display a formatted summary of all financial data
        public void displayBudgetSummary() {
            System.out.println("\n--- Budget Summary ---");
            System.out.println("Income: $" + String.format("%.2f", income));
            System.out.println("Tuition Fees: $" + String.format("%.2f", tuitionFees));
            System.out.println("Accommodation: $" + String.format("%.2f", accommodation));
            System.out.println("Food: $" + String.format("%.2f", food));
            System.out.println("Transportation: $" + String.format("%.2f", transportation));
            System.out.println("Personal Expenses: $" + String.format("%.2f", personalExpenses));
            System.out.println("Other Expenses: $" + String.format("%.2f", otherExpenses));
            System.out.println("----------------------");
            System.out.println("Remaining Budget: $" + String.format("%.2f", calculateRemainingBudget()));
            System.out.println("");
        }
    }
}
