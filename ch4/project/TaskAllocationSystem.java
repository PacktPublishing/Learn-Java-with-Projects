package ch4.project;

public class TaskAllocationSystem {
    public static void main(String[] args) {
        String role = "Feeding"; // role of the employee
        int time = 14; // current time in 24-hour format
        int safetyRating = 9; // safety rating of the park

        switch (role) {
            case "Feeding":
                if (time >= 7 && time <= 19) {
                    System.out.println("Your task is to feed the dinosaurs.");
                } else {
                    System.out.println("Feeding time is over. Please assist with cleaning tasks.");
                }
                break;
            case "Cleaning":
                System.out.println("Your task is to clean the enclosures.");
                break;
            case "Security":
                if (safetyRating < 8) {
                    System.out.println("Alert! The park's safety rating has fallen. Increase surveillance.");
                } else {
                    System.out.println("Your task is to ensure the park's safety.");
                }
                break;
            case "Tour Guiding":
                if (time >= 10 && time <= 19) {
                    System.out.println("Your task is to guide the park's visitors.");
                } else {
                    System.out.println("Tour guiding hours are over. Please assist with other tasks.");
                }
                break;
            default:
                System.out.println("Unknown job title.");
                break;
        }

    }
}
