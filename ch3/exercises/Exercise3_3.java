package ch3.exercises;

public class Exercise3_3 {
    public static void main(String[] args) {
        // Declare the current year
        int currentYear = 2023;

        // Check if it is a leap year
        boolean isLeapYear = currentYear % 4 == 0 && (currentYear % 100 != 0 || currentYear % 400 == 0);
        System.out.println("Is it a Leap Year? " + (isLeapYear ? "Yes" : "No"));

    }
}
