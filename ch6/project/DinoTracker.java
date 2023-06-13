package ch6.project;

public class DinoTracker {
    public static void main(String[] args) {
        String[] dinoNames = new String[10];
        int[] dinoAges = new int[10];
        String[] dinoSpecies = new String[10];
        int[] dinoEnclosures = new int[10];

        // Populating the arrays
        for (int i = 0; i < 5; i++) {
            dinoNames[i] = "Dino " + (i+1);
            dinoAges[i] = (i+1) * 2;
            dinoSpecies[i] = "Species " + (i+1);
            dinoEnclosures[i] = i+1;
        }

        // Displaying the details
        for (int i = 0; i < 5; i++) {
            System.out.println("Name: " + dinoNames[i] + ", Age: " + dinoAges[i] + ", Species: " + dinoSpecies[i] + ", Enclosure: " + dinoEnclosures[i]);
        }

        // Calculating and displaying average age
        int totalAge = 0;
        for (int age : dinoAges) {
            totalAge += age;
        }
        double averageAge = (double) totalAge / 5;  // assuming we have details for 5 dinosaurs
        System.out.println("Average age: " + averageAge);

    }
}
