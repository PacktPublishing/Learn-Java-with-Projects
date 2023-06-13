package ch7.exercises;

public class Exercise7_3 {
    public double getAverageAge(int[] ages) {
        int totalAge = 0;
        for (int age : ages) {
            totalAge += age;
        }
        return (double) totalAge / ages.length;
    }

}
