package ch16.exercises;

import java.util.Arrays;

public class Exercise16_3 {
    public static void main(String[] args) {
        int[] weights = {1000, 2000, 1500, 2300, 1700};
        int totalWeight = Arrays.stream(weights).sum();
        System.out.println("Total weight of all dinosaurs: " + totalWeight);

    }
}
