package ch12;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
//        usingKeyboard();
//        usingKeyboardExtra();
        usingFile();
//        usingString();
    }
    public static void usingString(){
        String input = "Maaike   delim vandelim Putten delim 22";
        Scanner sc = new Scanner(input).useDelimiter("\\s*delim\\s*");
        System.out.println(sc.next());
        System.out.println(sc.next());
        System.out.println(sc.next());
        System.out.println(sc.nextInt());
        sc.close();
    }
    public static void usingKeyboardExtra(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        System.out.println(sc.nextLine()); // Sean Kennedy
    }
//        System.out.print("Enter name: ");   // Type in Sean Kennedy
//        System.out.println(sc.next());      // Sean

    public static void usingFile(){
        // Relative path built from "current working directory", which is
        // obtained from user.dir setting -> System.getProperty("user.dir")
        // Mine was: C:\Users\skennedy\IdeaProjects\Learn-Java-with-Projects
        try (Scanner sc = new Scanner(
                new File("out\\production\\" +
                        "Learn-Java-with-Projects\\ch12\\ages.txt"))) {
            if(sc.hasNextInt()){
                int age = sc.nextInt();
                System.out.println(age);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
    public static void usingKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        if(sc.hasNextInt()){ // integer ready to be read
            int age = sc.nextInt();
            System.out.println(age);
        }
        // closes the underlying stream (System.in) which cannot be re-opened
        sc.close();
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter another age: ");
        int age = sc1.nextInt();    // NoSuchElementException
        System.out.println(age);
    }
}
// to get current user directory - used to build relative path to file
// System.out.println(System. getProperty("user.dir"));// C:\Users\skennedy\IdeaProjects\Learn-Java-with-Projects

// absolute path
//  sc = new Scanner(new File("C:\\Users\\skennedy\\IdeaProjects\\Learn-Java-with-Projects\\out\\production\\Learn-Java-with-Projects\\ch12\\ages.txt"));
