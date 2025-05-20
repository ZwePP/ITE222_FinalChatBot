import java.util.Scanner;

public class Student_Budget {

    public static class StudentBudgetCalculator { // Made the inner class static
        private double income;
        private double tuitionFees;
        private double accommodation;
        private double food;
        private double transportation;
        private double personalExpenses;
        private double otherExpenses;

        public StudentBudgetCalculator(double income) {
            this.income = income;
            this.tuitionFees = 0;
            this.accommodation = 0;
            this.food = 0;
            this.transportation = 0;
            this.personalExpenses = 0;
            this.otherExpenses = 0;
        }

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

        public double calculateRemainingBudget() {
            double totalExpenses = tuitionFees + accommodation + food + transportation + personalExpenses + otherExpenses;
            return income - totalExpenses;
        }

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
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- Student Budget Calculator ---");
            System.out.print("Enter your total income for the period: $");
            double income = scanner.nextDouble();
            StudentBudgetCalculator calculator = new StudentBudgetCalculator(income); // Corrected instantiation

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

            calculator.displayBudgetSummary();
            scanner.close();
        }
    }
}