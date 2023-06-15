package ch11.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exercise11_1 {
    public static void main(String[] args) {
        try {
            File file = new File("dinosaurData.txt");
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

    }
}
