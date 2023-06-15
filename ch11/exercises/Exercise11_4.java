package ch11.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise11_4 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("DinoDiet.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading file: " + e.getMessage());
        }

    }
}
