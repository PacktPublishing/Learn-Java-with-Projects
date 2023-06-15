package ch12.exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise12_5 {
    public static void main(String[] args) {
        List<String> suggestedNames = Arrays.asList("Steggy", "Theodore", "Veli");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < suggestedNames.size(); i++) {
            sb.append(suggestedNames.get(i));
            sb.append(" ");
        }
        String fullName = sb.toString().trim();
        System.out.println(fullName);

    }
}
