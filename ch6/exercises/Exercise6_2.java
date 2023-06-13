package ch6.exercises;

public class Exercise6_2 {
    public static void main(String[] args) {
        int[] dinoWeights = {7000, 50000, 500, 5000, 8000};
        int maxWeight = dinoWeights[0];

        for (int i = 1; i < dinoWeights.length; i++) {
            if (dinoWeights[i] > maxWeight) {
                maxWeight = dinoWeights[i];
            }
        }

        System.out.println("Heaviest dinosaur weighs: " + maxWeight + " kg");

    }
}
