package ch3.exercises;

public class Exercise3_4 {
    public static void main(String[] args) {
        // Declare the park's maximum capacity and the current number of visitors
        int maxCapacity = 10000; // per day
        int currentVisitors = 9500;

        // Check if the park's maximum capacity has been reached
        boolean maxCapacityReached = currentVisitors >= maxCapacity;
        System.out.println("Max capacity reached: " + maxCapacityReached);

    }
}
