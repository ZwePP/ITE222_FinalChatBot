import java.util.Scanner;

public class Academic_Calendar {

   
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Helper method to get the number of days in a month
    public static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) { // February
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 0; 
        }
    }

    // Helper method to get the name of the month
    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    // Helper method to calculate the day of the week for a given date
    // (Zeller's congruence adaptation for a Gregorian calendar, adjusted for Sunday=0)
    // Assumes year is between 1700 and 2299 for simplicity
    public static int getDayOfWeek(int year, int month, int day) {
        // Adjust month and year for Zeller's congruence
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int k = year % 100; // Year of the century
        int j = year / 100; // Century

        // Zeller's congruence formula
        int h = (day + (13 * (month + 1) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7;

        // Zeller's result: 0 = Saturday, 1 = Sunday, ..., 6 = Friday
        // We want 0 = Sunday, 1 = Monday, ..., 6 = Saturday
        return (h + 6) % 7;
    }


    // Checks if a given date (year, month, day) is a fake holiday
    public static boolean isHoliday(int year, int month, int day) {
        if (year == 2025) {
            // New Year's Day
            if (month == 1 && day == 1) return true;
            // Fake Winter Break (Feb 10 - Feb 17)
            if (month == 2 && day >= 10 && day <= 17) return true;
            // Fake Spring Festival (Apr 13 - Apr 20)
            if (month == 4 && day >= 13 && day <= 20) return true;
            // Fake Summer Holiday (Jul 4 - Jul 11)
            if (month == 7 && day >= 4 && day <=11) return true;
            // Fake Christmas Day
            if (month == 12 && day == 25) return true;
        } else if (year == 2026) {
            // New Year's Day
            if (month == 1 && day == 1) return true;
            // Fake Winter Break (Feb 2 - Feb 9)
            if (month == 2 && day >= 2 && day <= 9) return true;
            // Fake Spring Festival (Apr 5 - Apr 12)
            if (month == 4 && day >= 5 && day <= 12) return true;
            // Fake Summer Holiday (Jul 6 - Jul 13)
            if (month == 7 && day >= 6 && day <= 13) return true;
            // Fake Christmas Day
            if (month == 12 && day == 25) return true;
        }
        return false;
    }

    // Checks if a given date (year, month, day) is a fake exam date
    public static boolean isExamDate(int year, int month, int day) {
        if (year == 2025) {
            // Mid-term Exam Period (May 15 - May 22)
            if (month == 5 && day >= 15 && day <= 22) return true;
            // Final Exam Period (Nov 20 - Nov 27)
            if (month == 11 && day >= 20 && day <= 27) return true;
        } else if (year == 2026) {
            // Mid-term Exam Period (May 18 - May 25)
            if (month == 5 && day >= 18 && day <= 25) return true;
            // Final Exam Period (Nov 24 - Dec 1)
            if (month == 11 && day >= 24) return true; // Nov 24 to Nov 30
            if (month == 12 && day == 1) return true;  // Dec 1
        }
        return false;
    }


    public static void displayCalendar(int year) {
        System.out.println("\n--- Academic Calendar for " + year + " ---");

        // Loop through each month
        for (int month = 1; month <= 12; month++) {
            System.out.println("\n----- " + getMonthName(month) + " " + year + " -----");
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            // Get the first day of the month's day of the week (0=Sunday, 6=Saturday)
            int startDayOfWeek = getDayOfWeek(year, month, 1);

            // Print leading spaces
            for (int i = 0; i < startDayOfWeek; i++) {
                System.out.print("    ");
            }

            int daysInMonth = getDaysInMonth(year, month);
            for (int day = 1; day <= daysInMonth; day++) {
                String dayStr = String.format("%3d", day);

                boolean isHoliday = isFakeHoliday(year, month, day);
                boolean isExamDate = isFakeExamDate(year, month, day);

                if (isExamDate) {
                    dayStr += "X"; // Mark exam dates with 'X'
                } else if (isHoliday) {
                    dayStr += "*"; // Mark holidays with '*'
                } else {
                    dayStr += " "; // No special mark
                }

                System.out.print(dayStr);

                // Move to next line after Saturday
                if ((startDayOfWeek + day) % 7 == 0) {
                    System.out.println();
                }
            }
            // Ensure there's a new line at the end of each month's grid
            if ((startDayOfWeek + daysInMonth) % 7 != 0) {
                System.out.println();
            }
        }

        System.out.println("\n* indicates a holiday.");
        System.out.println("X indicates a fake exam date.");
        System.out.println("--- End of Calendar for " + year + " ---");

        System.out.println("\n--- Holidays and Exam Dates for " + year + " ---");
        if (year == 2025) {
            System.out.println("2025-01-01 - New Year's Day (Holiday)");
            System.out.println("2025-02-10 to 2025-02-17 - Fake Winter Break (Holiday)");
            System.out.println("2025-04-13 to 2025-04-20 - Fake Spring Festival (Holiday)");
            System.out.println("2025-05-15 to 2025-05-22 - Mid-term Exam Period (Exam Date)");
            System.out.println("2025-07-04 to 2025-07-11 - Fake Summer Holiday (Holiday)");
            System.out.println("2025-11-20 to 2025-11-27 - Final Exam Period (Fake Exam Date)");
            System.out.println("2025-12-25 - Fake Christmas Day (Holiday)");
        } else if (year == 2026) {
            System.out.println("2026-01-01 - New Year's Day (Holiday)");
            System.out.println("2026-02-02 to 2026-02-09 -  Winter Break (Holiday)");
            System.out.println("2026-04-05 to 2026-04-12 -  Spring Festival (Holiday)");
            System.out.println("2026-05-18 to 2026-05-25 - Mid-term Exam Period ");
            System.out.println("2026-07-06 to 2026-07-13 - Fake Summer Holiday (Holiday)");
            System.out.println("2026-11-24 to 2026-12-01 - Final Exam Period");
            System.out.println("2026-12-25 - Fake Christmas Day (Holiday)");
        }
        System.out.println("--- End of Holidays and Exam Dates for " + year + " ---");
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
