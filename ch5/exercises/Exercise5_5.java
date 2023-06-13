package ch5.exercises;

public class Exercise5_5 {
    public static void main(String[] args) {
        int ticketsLeft = 100; // set this to the number of tickets available

        while (ticketsLeft > 0) {
            System.out.println("Selling a ticket...");
            ticketsLeft--;
        }

        System.out.println("All tickets sold out!");

    }
}
