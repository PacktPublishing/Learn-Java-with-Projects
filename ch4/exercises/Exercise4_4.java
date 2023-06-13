package ch4.exercises;

public class Exercise4_4 {
    public static void main(String[] args) {
        int safetyRating = 7; // on a scale from 1 to 10
        int safetyThreshold = 8; // safety threshold

        if (safetyRating < safetyThreshold) {
            System.out.println("Warning: The park's safety rating has fallen below the threshold!");
        }

    }
}
