package ch4;

import java.util.Scanner;

public class ConditionLogic {
    public static void main(String[] args) {
        //ifStmt();
        //ifDaysInMonth();
        //danglingElse();
        //switchStmt();
        //switchExamples();
        //switchExpressions();
    }
    public static void switchExpressions(){
        // switch statement (nothing returned)
        int nLetters=0;
        String name="Jane";
        switch(name){
            case "Jane":
            case "Sean":
            case "Alan":
            case "Paul":
                nLetters = 4;
                break;
            case "Janet":
            case "Susan":
                nLetters = 5;
                break;
            case "Maaike":
            case "Alison":
            case "Miriam":
                nLetters = 6;
                break;
            default:
                System.out.println("Unrecognized name: "+name);
                nLetters = -1;
                break;
        }
        System.out.println(nLetters);
        // switch expression for the above
        nLetters = switch(name){
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison" , "Miriam" -> 6;
            default -> {
                System.out.println("Unrecognized name: "+name);
                yield -1; // 'nLetters' initialized to -1
            }
        };
        System.out.println(nLetters);

        // switch expression returning straight back to System.out.println
        System.out.println(switch(name){
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison" , "Miriam" -> 6;
            default -> "Unrecognized name: "+name;
        });

        nLetters = switch(name){   // switch expressions with code blocks
            case "Jane", "Sean", "Alan", "Paul" -> {
                System.out.println("There are 4 letters in: " + name);
                yield 4;
            }
            case "Janet", "Susan" -> {
                System.out.println("There are 5 letters in: "+name);
                yield 5;
            }
            case "Maaike", "Alison" , "Miriam" -> {
                System.out.println("There are 6 letters in: "+name);
                yield 6;
            }
            default -> {
                System.out.println("Unrecognized name: "+name);
                yield -1;
            }
        };
        System.out.println(nLetters);

        // mix and match
        // switch statement using new case labels - refactored the big, verbose one
        switch(name){
            case "Jane", "Sean", "Alan", "Paul" -> nLetters = 4;
            case "Janet", "Susan" -> nLetters = 5;
            case "Maaike", "Alison" , "Miriam" -> nLetters = 6;
            default -> {
                System.out.println("Unrecognized name: "+name);
                nLetters = -1;
            }
        }
        System.out.println(nLetters);

        // switch expression using old case labels - refactored 'yield' example
        nLetters = switch(name){
            case "Jane":
            case "Sean":
            case "Alan":
            case "Paul":
                System.out.println("There are 4 letters in: " + name);
                yield 4;
            case "Janet":
            case "Susan":
                System.out.println("There are 5 letters in: "+name);
                yield 5;
            case "Maaike":
            case "Alison":
            case "Miriam":
                System.out.println("There are 6 letters in: "+name);
                yield 6;
            default:
                System.out.println("Unrecognized name: "+name);
                yield -1;
        };
        System.out.println(nLetters);

    }
    public static void switchExamples(){
        // no case labels allowed
        switch("abc"){
        }
        int x=2;
        switch(x) {

        }

    /*    Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sport --> ");
        String sport = sc.next();
        switch(sport){
            case "Soccer":
                System.out.println("I play soccer");
                break;
            case "Rugby":
                System.out.println("I play Rugby");
                break;
            default:// can be moved around
                System.out.println("Unknown sport");
                break;
        }*/

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (1..10) --> ");
        int number = sc.nextInt();
        final int two = 2; // compile-time constant
        switch(number){
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                System.out.println(number + " is odd.");
                break;
            case two:
            case 4: case 6: case 8: case 10:
                System.out.println(number + " is even.");
                break;
            default:
                System.out.println( number + " is outside range (1..10).");
                break;
        }
        // duplicates not allowed
        // case labels must be in range
        // must be constants
        // switch expressions
        byte b = 3;
        switch(b){
            case 127: case -128:
                System.out.println("ok");
                break;
//            case 128:
//            case 12:
//            case 12:
        }
    }
    public static void switchStmt(){
        final int JAN=1;  final int FEB=2;  final int MAR=3; // define constants
        final int APR=4;  final int MAY=5;  final int JUN=6;
        final int JUL=7;  final int AUG=8;  final int SEP=9;
        final int OCT=10; final int NOV=11; final int DEC=12;

        Scanner sc = new Scanner(System.in);    // import java.util.Scanner;
        System.out.print("Enter month --> ");
        int month = sc.nextInt();

        int numDays=0;
        switch(month){
            case JAN:case MAR:case MAY:case JUL: case AUG:case OCT:case DEC:
                numDays=31;
                break;
            case APR:case JUN:case SEP:case NOV:
                numDays=30;
                break;
            case FEB:
                System.out.print("Enter year --> ");
                int year = sc.nextInt();
//                if( (A)         || (        B         &&       C)    ){
                if( (year % 400 == 0) || (year % 4 == 0 && !(year % 100 == 0)) ){
                    numDays = 29; // leap year e.g. 2000, 2012, 2016
                }else{
                    numDays = 28;   // 1900 (divisible by 100)
                }
                break;
            default:
                System.out.println("Invalid month: "+month);
                break;

        }
        if(numDays > 0){
            System.out.println("Number of days is: "+numDays);
        }

    }
    public static void danglingElse(){
        boolean flag=false;
        if (flag)
        if (flag)
        System .out.println("True True");
        else
        System.out.println("True False");

        if (flag)
            if (flag)
                System .out.println("True True");
            else
                System.out.println("True False");

        if (flag) {
            if (flag) {
                System.out.println("True True");
            }
            else {
                System.out.println("True False");
            }
        }
/*
        boolean flag=true;
        if (flag)
        if (flag)
        System .out.println("True True");
        else
        System.out.println("True False");
        else
        System.out.println("False");

        if (flag)
            if (flag)
                System .out.println("True True");
            else
                System.out.println("True False");
        else
            System.out.println("False");

*/
    }
    public static void ifDaysInMonth(){
        final int JAN=1;final int FEB=2;final int MAR=3; // define constants
        final int APR=4;final int MAY=5;final int JUN=6;
        final int JUL=7;final int AUG=8;final int SEP=9;
        final int OCT=10;final int NOV=11;final int DEC=12;

        Scanner sc = new Scanner(System.in);    // import java.util.Scanner;
        System.out.print("Enter month (1..12) --> ");
        int month = sc.nextInt();

        int numDays=0;
        if(month == JAN || month == MAR || month == MAY || month == JUL
                || month == AUG || month == OCT || month == DEC) {
            numDays=31;
        } else if (month == APR || month == JUN || month == SEP || month == NOV) {
            numDays=30;
        } else if (month == FEB) {
            System.out.print("Enter year --> ");
            int year = sc.nextInt();
//                if( (A)         || (    B         &&       C)    ){
            if( (year % 400 == 0) || (year % 4 == 0 && !(year % 100 == 0)) ){
                numDays = 29; // leap year e.g. 2000, 2012, 2016
            }else{
                numDays = 28;   // 1900 (divisible by 100)
            }
        } else {
            System.out.println("Invalid month: "+month);
        }
        if(numDays > 0){
            System.out.println("Number of days is: "+numDays);
        }
    }

    public static void ifStmt(){

        int x=5, y=4;
        if(x > y)
            System.out.println(x + " > "+y);
        if(x < y)
            System.out.println(x + " < "+y);
        if(x == y){
            String s = x + " == "+y;
            System.out.println(s);
        }

/*
        int x=4, y=5;
        if(x > y) {
            System.out.println(x + " > " + y);
        } else if(x < y) {
            System.out.println(x + " < " + y);
        } else if(x == y){
            System.out.println(x + " == " + y);
        }
        System.out.println("Here");
*/
/*        int x=4, y=4;
        if(x > y) {
            System.out.println(x + " > " + y);
        } else if(x < y) {
            System.out.println(x + " < " + y);
        } else { //if(x == y){
            System.out.println(x + " == " + y);
        }
        System.out.println("Here");
*/
    }
}

/* save
        nLetters = switch(name){
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison" , "Miriam" -> 6;
            default -> throw new IllegalStateException("Unrecognized name: "+name);
        };
        System.out.println(nLetters);

        System.out.println(switch(name){
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison" , "Miriam" -> 6;
            default -> throw new IllegalStateException("Unrecognized name: "+name);
        });

 */