package StamfordChatBot;

import java.util.Scanner;

public class Stamford_Chatbot_Schedule {
    // 2D array to store calendar grid (6 weeks x 7 days)
    private String[][] calendarGrid = new String[6][7];

    // Constructor: handles user input to choose year or exit
    public Stamford_Chatbot_Schedule() {
        Scanner scanner = new Scanner(System.in);
        int year;
        while (true) {
            System.out.print("Enter the year (2025 or 2026) to view the academic calendar (or 0 to exit): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (year == 2025 || year == 2026) {
                    displayCalendar(year); // Display calendar for the selected year
                } else if (year == 0) {
                    System.out.println("Exiting Academic Calendar.");
                    System.out.println("");
                    break; // Exit loop
                } else {
                    System.out.println("Invalid year. Please enter 2025 or 2026.");
                }
            } else {
                System.out.println("Invalid input. Please enter a year as a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    // Main method to display the academic calendar
    public void displayCalendar(int year) {
        System.out.println("\n--- Academic Calendar for " + year + " ---");

        // Loop through all 12 months
        for (int month = 1; month <= 12; month++) {
            resetCalendarGrid(); // Clear the calendar grid for each new month

            System.out.println("\n----- " + getMonthName(month) + " " + year + " -----");
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            int startDay = getDayOfWeek(year, month, 1); // Find first day of the month
            int daysInMonth = getDaysInMonth(year, month); // Total number of days in the month

            // Fill in the calendar grid with days
            int row = 0;
            int col = startDay;
            for (int day = 1; day <= daysInMonth; day++) {
                String dayStr = String.format("%2d", day); // Format day

                // Mark holidays and exams
                if (isExamDate(year, month, day)) {
                    dayStr += "X"; // X for exam
                } else if (isHoliday(year, month, day)) {
                    dayStr += "*"; // * for holiday
                } else {
                    dayStr += " "; // Empty space for normal days
                }

                calendarGrid[row][col] = dayStr; // Add to grid
                col++;

                // Move to next row (week) if needed
                if (col > 6) {
                    col = 0;
                    row++;
                }
            }

            // Print the completed calendar grid
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (calendarGrid[i][j] == null) {
                        System.out.print("    "); // Empty cell
                    } else {
                        System.out.print(calendarGrid[i][j] + " "); // Print date
                    }
                }
                System.out.println();
            }
        }

        printEventSummary(year); // Show all holidays and exams
    }

    // Reset the calendar grid to null
    private void resetCalendarGrid() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calendarGrid[i][j] = null;
            }
        }
    }

    // Print a summary of holidays and exam dates for the year
    private void printEventSummary(int year) {
        System.out.println("\n* indicates a holiday.");
        System.out.println("X indicates a exam date.");
        System.out.println("--- End of Calendar for " + year + " ---");

        System.out.println("\n--- Holidays and Exam Dates for " + year + " ---");
        if (year == 2025) {
            System.out.println("2025-01-01 - New Year's Day (Holiday)");
            System.out.println("2025-02-10 to 2025-02-17 - Winter Break (Holiday)");
            System.out.println("2025-05-15 to 2025-05-22 - Mid-term Exam Period (Exam Date)");
        } else if (year == 2026) {
            System.out.println("2026-01-01 - New Year's Day (Holiday)");
            System.out.println("2026-02-02 to 2026-02-09 - Winter Break (Holiday)");
            System.out.println("2026-05-18 to 2026-05-25 - Mid-term Exam Period (Exam Date)");
        }
        System.out.println("--- End of Holidays and Exam Dates ---\n");
    }

    // Check if a given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Return number of days in a given month
    public static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
            month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 0;
        }
    }

    // Convert month number to name
    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    // Calculate day of the week using Zeller's Congruence
    public static int getDayOfWeek(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int h = (day + (13 * (month + 1) / 5) + k + (k / 4)
                + (j / 4) - (2 * j)) % 7;

        return (h + 6) % 7; // Adjust to make Sunday = 0
    }

    // Determine if a date is a holiday
    public static boolean isHoliday(int year, int month, int day) {
        if (year == 2025) {
            if (month == 1 && day == 1) return true; // New Year's
            if (month == 2 && day >= 10 && day <= 17) return true; // Winter Break
            if (month == 4 && day >= 13 && day <= 20) return true; // Spring Festival
            if (month == 7 && day >= 4 && day <= 11) return true; // Summer Break
            if (month == 12 && day == 25) return true; // Christmas
        } else if (year == 2026) {
            if (month == 1 && day == 1) return true;
            if (month == 2 && day >= 2 && day <= 9) return true;
            if (month == 4 && day >= 5 && day <= 12) return true;
            if (month == 7 && day >= 6 && day <= 13) return true;
            if (month == 12 && day == 25) return true;
        }
        return false;
    }

    // Determine if a date is part of an exam period
    public static boolean isExamDate(int year, int month, int day) {
        if (year == 2025) {
            if (month == 5 && day >= 15 && day <= 22) return true; // Mid-term
            if (month == 11 && day >= 20 && day <= 27) return true; // Final
        } else if (year == 2026) {
            if (month == 5 && day >= 18 && day <= 25) return true; // Mid-term
            if (month == 11 && day >= 24) return true; // Final part 1
            if (month == 12 && day == 1) return true; // Final part 2
        }
        return false;
    }
}
