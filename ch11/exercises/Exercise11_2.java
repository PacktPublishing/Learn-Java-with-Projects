package ch11.exercises;


public class Exercise11_2 {
    void updateDinosaurWeight(Dinosaur dinosaur, int weight) {
        try {
            if (weight < 0) {
                throw new IllegalArgumentException("Weight can't be negative");
            }
            dinosaur.setWeight(weight);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
