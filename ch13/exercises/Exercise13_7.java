package ch13.exercises;

import java.time.LocalTime;
import java.util.*;

public class Exercise13_7 {
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

        System.out.println("Your order:");
        for (Map<String, Integer> order : orders) {
            for (Map.Entry<String, Integer> entry : order.entrySet()) {
                System.out.println(entry.getValue() + " scoop(s) of " + entry.getKey() + " flavor");
            }
        }
        LocalTime readyTime = LocalTime.now().plusMinutes(10);
        System.out.println("Your order will be ready at " + readyTime);


    }
}
