package ch11;

import java.io.FileReader;
import java.io.IOException;

public class FileResourceCleanup {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("input.txt");
            int character;
            while ((character = reader.read()) !=-1){
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Err: " + e.getMessage());
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Err closing: " + e.getMessage());
                }
            }
        }
    }
}
