package ch3.exercises;

public class Exercise3_6 {
    public static void main(String[] args) {
        // Declare the park's safety rating and the safety threshold
        int safetyRating = 9; // on a scale of 1 to 10
        int safetyThreshold = 8;

        // Check if the park's safety rating is above the threshold
        boolean isAboveThreshold = safetyRating > safetyThreshold;
        System.out.println("Is the safety rating above the threshold? " + (isAboveThreshold ? "Yes" : "No"));

    }
}
