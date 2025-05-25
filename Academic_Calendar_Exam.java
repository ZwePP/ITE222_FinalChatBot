import java.util.Scanner;

public class Academic_Calendar {

    // Helper method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Helper method to get the number of days in a month
    public static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return 31;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                return 30;
            case 2: // February
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // Should not happen for valid months
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
    public static boolean isFakeHoliday(int year, int month, int day) {
        if (year == 2025) {
            // New Year's Day
            if (month == 1 && day == 1) return true;
            // Fake Winter Break (Feb 10 - Feb 17)
            if (month == 2 && day >= 10 && day <= 17) return true;
            // Fake Spring Festival (Apr 13 - Apr 20)
            if (month == 4 && day >= 13 && day <= 20) return true;
            // Fake Summer Holiday (Jul 4 - Jul 11)
            if (month == 7 && day >= 4 && day <=