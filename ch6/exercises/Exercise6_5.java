package ch6.exercises;

public class Exercise6_5 {
    public static void main(String[] args) {
        int[] dinoAges = {10, 15, 7, 20, 5};
        int totalAge = 0;

        for (int age : dinoAges) {
            totalAge += age;
        }

        double averageAge = (double) totalAge / dinoAges.length;
        System.out.println("Average age of dinosaurs: " + averageAge);

    }
}
