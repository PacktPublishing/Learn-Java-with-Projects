package ch4.exercises;

public class Exercise4_2 {
    public static void main(String[] args) {
        String species = "T-Rex"; // change this variable to test the code

        switch (species) {
            case "T-Rex":
                System.out.println("The T-Rex is a large and powerful dinosaur.");
                break;
            case "Velociraptor":
                System.out.println("The Velociraptor is a small, agile and intelligent dinosaur.");
                break;
            // add other species cases as needed
            default:
                System.out.println("Unknown dinosaur species.");
                break;
        }

    }
}
