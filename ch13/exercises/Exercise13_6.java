package ch13.exercises;

import java.util.*;

public class Exercise13_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many ice creams would the guest like?");
        int numIceCreams = scanner.nextInt();

        List<Map<String, Integer>> orders = new ArrayList<>();
        for (int i = 0; i < numIceCreams; i++) {
            System.out.println("What flavor for ice cream " + (i + 1) + "?");
            String flavor = scanner.next();

            System.out.println("How many scoops for ice cream " + (i + 1) + "?");
            int scoops = scanner.nextInt();

            Map<String, Integer> order = new HashMap<>();
            order.put(flavor, scoops);
            orders.add(order);
        }

    }
}
