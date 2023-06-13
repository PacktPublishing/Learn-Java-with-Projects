package ch7.project;
import java.util.Scanner;

public class MesozoicEdenAssistant {

        // Use Scanner for reading input from the user
        Scanner scanner = new Scanner(System.in);

        // Initialize arrays to store dinosaur information
        String[] dinoNames = new String[10];
        int[] dinoAges = new int[10];
        int[] dinoWeights = new int[10];
        int dinoCount = 0;

        public static void main(String[] args) {
            MesozoicEdenAssistant main = new MesozoicEdenAssistant();
            main.start();
        }

        public void start() {
            // This is the main loop of the application. It will keep running until the user decides to exit.
            while (true) {
                displayMenu();
                int choice = scanner.nextInt();
                handleMenuChoice(choice);
            }
        }

        public void displayMenu() {
            System.out.println("Welcome to Mesozoic Eden Assistant!");
            System.out.println("1. Add Dinosaur");
            System.out.println("2. Check Park Hours");
            System.out.println("3. Greet Guest");
            System.out.println("4. Check Visitors Count");
            System.out.println("5. Manage Staff");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
        }

        public void handleMenuChoice(int choice) {
            switch (choice) {
                case 1:
                    addDinosaur();
                    break;
                case 2:
                    checkParkHours();
                    break;
                case 3:
                    // greetGuest();
                    break;
                case 4:
                    // checkVisitorsCount();
                    break;
                case 5:
                    // manageStaff();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }

        public void addDinosaur() {
            if (dinoCount >= 10) {
                System.out.println("The park is at full capacity. No more dinosaurs can be added.");
                return;
            }

            scanner.nextLine();  // clear the input
            System.out.println("Enter dinosaur name: ");
            dinoNames[dinoCount] = scanner.nextLine();
            System.out.println("Enter dinosaur age: ");
            dinoAges[dinoCount] = scanner.nextInt();
            System.out.println("Enter dinosaur weight: ");
            dinoWeights[dinoCount] = scanner.nextInt();
            dinoCount++;

            System.out.println(dinoNames[dinoCount - 1] + " has been added to the park!");
        }

        public void checkParkHours() {
            // Assuming the park is open from 8 am to 6 pm.
            int currentHour = java.time.LocalTime.now().getHour();
            if (currentHour >= 8 && currentHour < 18) {
                System.out.println("The park is currently open.");
            } else {
                System.out.println("The park is currently closed.");
            }
        }
    }


