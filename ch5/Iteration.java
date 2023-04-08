package ch5;

import java.util.Scanner;

public class Iteration {
    public static void main(String[] args) {
//        whileLoops();
//        forLoops();
//        nestedLoops();
//        normalBreak();
//        labeledBreak();
//        normalContinue();
        labeledContinue();
    }
    public static void labeledContinue() {
        // once j==3 in inner loop, control passes to next iteration of outer loop

        /* Output:
            i, j
            ====
            1, 1
            1, 2
            2, 1
            2, 2
            3, 1
            3, 2 */

        System.out.println("i, j\n===="); // placed BEFORE label!!
        OUTERLOOP:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    continue OUTERLOOP;// continues with OUTERLOOP
                }
                System.out.println(i + ", " + j);
            }
        }
    }
    public static void normalContinue() {
        // "j == 3" missing each time from inner loop
        System.out.println("i, j");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    continue; // next iteration
                }
                System.out.println(i + ", " + j);
            }
        }
    }


    public static void normalBreak(){
        System.out.println("i, j");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    break; // breaks out of inner loop
                }
                System.out.println(i + ", " + j);
            }
        }
    }
    public static void labeledBreak() {
        System.out.println("i, j"); // placed BEFORE label!!
        OUTERLOOP:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    break OUTERLOOP;// case sensitive
                }
                System.out.println(i + ", " + j);
            }
        }
        System.out.println("here");

//        for (int i = 1; i <= 3; i++) {
//            for (int j = 1; j <= 5; j++) {
//                if (j == 3) {
//                    break OUTERLOOP;// case sensitive, breaks out of OUTERLOOP
//                }
//                System.out.println(i + ", " + j);
//            }
//        }


        LOOP2:
        for (int i = 1; i <= 3; i++) {
            if(i==1){
                break LOOP2;
            }
        }

    }

    public static void nestedLoops(){
        int[] data = {9, 3, 5, 7};

        System.out.println("[]\t[n]\tHistogram");
        for (int i=0; i<data.length; i++){
            System.out.print(i + "\t" + data[i] + "\t");
            for(int j=1; j<=data[i]; j++) { // write out data[i] stars
                System.out.print("*");      // print() not println()
            }
            System.out.println();		    // go onto next line
        }
    }
    public static void forLoops(){
        // for(init; booleanExpr; incr/decr)
//        for(int i=1; i<=3; i++){
//            System.out.println(i); // 1,2,3
//        }

//        for(int i=3; i>=1; i--){
//            System.out.println(i); // 3,2,1
//        }

//        for(int i=1; i<=3; i++);{
//            System.out.println("Looping"); // only appears once!
//        }

//        for(int i=10; i<=50; i+=10){
//            System.out.println(i); // 10, 20, 30, 40, 50
//        }
        //System.out.println(i); // i is out of scope

//        for(int i=0, j=0; i<1 && j<1; i++, j++){
//            System.out.println(i + " " + j); // 0 0
//        }

//        int[] ia = {1,2,3};
//        for(int i=0; i<ia.length; i++){
//            System.out.println(ia[i]); // 1, 2, 3
//        }

//        int[] ia = {1,2,3};
//        for(int n:ia){
//            System.out.println(n); // 1, 2, 3
//        }
    }
    public static void whileLoops(){

//        int x=1;
//
//        while (x <= 3){
//            System.out.println("Loop: "+x); // 1, 2, 3
//            x++;
//        }
//        System.out.println("Final x value is: "+x); // 4

//        int sum = 0;
//        boolean keepGoing=true;
//        do {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter a number (negative number to exit) --> ");
//            int n = sc.nextInt();
//            if(n < 0){
//                keepGoing = false;
//            } else{
//                sum = sum + n; // sum += n
//            }
//        } while(keepGoing);
//        System.out.println("Sum of numbers is: "+sum);

        /*
        int sum = 0;
        boolean keepGoing=true;
        while(keepGoing){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number (negative number to exit) --> ");
            int n = sc.nextInt();
            if(n < 0){
                keepGoing = false;
            } else{
                sum = sum + n; // sum += n
            }
        }
        System.out.println("Sum of numbers is: "+sum);
*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your age -- > ");
        int age = sc.nextInt();
        do{
            // purchase alcohol...
            System.out.println("As you are "+age+" years of age, " +
                    "you can purchase alcohol.");

            System.out.println("Please enter your age -- > ");
            age = sc.nextInt();
        }while (age >= 18);

//        while(age >= 18){
//            // purchase alcohol...
//            System.out.println("As you are "+age+" years of age, " +
//                    "you can purchase alcohol.");
//
//            System.out.println("Please enter your age -- > ");
//            age = sc.nextInt();
//        }

    }
}
