package ch2.project;

public class ProfileGenerator {
    public static void main(String[] args) {
        //Declare variables
        String dinoName = "Rexy";
        int dinoAge = 7; //in years
        String species = "T-Rex";
        String diet = "Carnivore";
        double weight = 8000; //in kilograms

        //Print the dinosaur profile
        System.out.println("Meet " + dinoName + ", a " + dinoAge + "-year-old " + species + ". As a " + diet + ", it has a robust weight of " + weight + " kilograms.");

    }
}
