import java.util.Scanner;

public class Academic_Calendar {

    public static void displayCalendar(int year) {
        System.out.println("\n--- Academic Calendar for " + year + " ---");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

   
        int dayOfMonth = 1;

     
        System.out.println("\n* indicates a holiday.");
        System.out.println("--- End of Calendar for " + year + " ---");

        System.out.println("\n--- Holidays for " + year + " ---");
        if (year == 2025) {
            System.out.println("2025-01-01 - New Year's Day");
            System.out.println("2025-02-10 - Fake Winter Break Start");
            System.out.println("2025-02-17 - Fake Winter Break End");
            System.out.println("2025-04-13 - Fake Spring Festival Start");
            System.out.println("2025-04-20 - Fake Spring Festival End");
            System.out.println("2025-07-04 - Fake Summer Holiday Start");
            System.out.println("2025-07-11 - Fake Summer Holiday End");
            System.out.println("2025-12-25 - Fake Christmas Day");
        } else if (year == 2026) {
            System.out.println("2026-01-01 - New Year's Day");
            System.out.println("2026-02-02 - Fake Winter Break Start");
            System.out.println("2026-02-09 - Fake Winter Break End");
            System.out.println("2026-04-05 - Fake Spring Festival Start");
            System.out.println("2026-04-12 - Fake Spring Festival End");
            System.out.println("2026-07-06 - Fake Summer Holiday Start");
            System.out.println("2026-07-13 - Fake Summer Holiday End");
            System.out.println("2026-12-25 - Fake Christmas Day");
        }
        System.out.println("--- End of Holidays for " + year + " ---");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;

        while (true) {
            System.out.print("Enter the year (2025 or 2026) to view the academic calendar and holidays (or 0 to exit): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (year == 2025 || year == 2026) {
                    displayCalendar(year);
                } else if (year == 0) {
                    System.out.println("Exiting Academic Calendar.");
                    break;
                } else {
                    System.out.println("Invalid year. Please enter 2025 or 2026.");
                }
            } else {
                System.out.println("Invalid input. Please enter a year as a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
        scanner.close();
    }
}