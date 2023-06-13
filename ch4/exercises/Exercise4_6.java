package ch4.exercises;

public class Exercise4_6 {
    public static void main(String[] args) {
        double weight = 8000; // dinosaur weight in kilograms

        if (weight < 500) {
            System.out.println("Feed the dinosaur once a day.");
        } else if (weight < 2000) {
            System.out.println("Feed the dinosaur twice a day.");
        } else {
            System.out.println("Feed the dinosaur three times a day.");
        }

    }
}
