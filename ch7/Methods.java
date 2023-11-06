package ch7;

public class Methods {
    public static void main(String[] args) {
        m1();                // 0
        m1(1);         // 1
        m1(1, 2);      // 3
        m1(1, 2, 3);   // 6
    }
    public static void m1(int... args){ // varargs
        int sum = 0;
        for(int i:args){
            sum += i;
        }
        System.out.println(sum);
    }
}

/*
public class Methods {
    public static void main(String[] args) {
        int result = performCalc(10, 2, "+"); // method call; passing down "arguments"
        System.out.println(result); // 12
        System.out.println(performCalc(10, 2, "-")); // 8
        System.out.println(performCalc(10, 2, "*")); // 20
        System.out.println(performCalc(10, 2, "/")); // 5
        performCalc(10, 2, "%");// return value ignored
        System.out.println(performCalc(10, 2, "&")); // Unrecognized operation: &, -1
    }
    public static int performCalc(int x, int y, String operation){  // "parameters"
        int result = switch(operation){
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "%" -> x % y;
            default -> {
                System.out.println("Unrecognized operation: "+operation);
                yield -1; // error
            }
        };
        return result;
    }
}
*/
/*
public class Methods {
    public static void main(String[] args) {
//        m1();         // 0
//        m1(1);        // 1
//        m1(1, 2);     // 3
//        m1(1, 2, 3);  // 6
    }
    public static void m1(String s, int... args){}
    //public static void m1(int... args, String s){}
    public static void m1(int[] args){}
}
*/

/*
public class Methods {
    public static void main(String[] args) {
        m1();           // 0
        m1(1);          // 1
        m1(1, 2);       // 3
        m1(1, 2, 3);    // 6
    }
    public static void m1(int... args){ // varargs
        int sum = 0;
        for(int i:args){
            sum += i;
        }
        System.out.println(sum);
    }
}

 */
/*
public class Methods {
    public static void main(String[] args) {
        System.out.println("main: before call to simpleExample()");
        simpleExample(); // method call
        System.out.println("main: after call to simpleExample()");
    }
    public static void simpleExample(){ // method definition
        System.out.println("\tExecuting simpleExample() method...");
    }
}
*/

/*
package ch7;

public class Methods {
    public static void main(String[] args) {
        int x = 19;         // primitive
        int[] arr = {1, 2}; // array
        callByValue(x, arr);
        System.out.println(x); // 19, unchanged
        System.out.println(arr[0] + ", " + arr[1]); // -1, 2
        x = callByValue(x, arr);
        System.out.println(x); // -1, changed
    }
    public static int callByValue(int x, int[] arr){
        x       = -1;
        arr[0]  = -1;
        return x;
    }
}
*/
/*
public class Methods {
    public static void main(String[] args) {
        m1();
        m1("A");
        System.out.println();
        m1("A", "B");
        System.out.println();
        m1("A", "B", "C");
    }
//    public static void m1(int n, String... args){}
//    public static void m1(String... args, int n){}
//    public static void m1(String[] args){} // this is not varargs

    public static void m1(String... args){ // varargs
        for(int i=0; i<args.length; i++){
            System.out.println(args[i]);
        }
        for(String s:args){
            System.out.println(s);
        }
    }
}
*/

/*
public class Methods {
    public static void main(String[] args) {
    }
    public static void someMethod(){}
    public static void someMethod(int x){}
    public static void someMethod(double x){}
    public static void someMethod(String x){}
    public static void someMethod(double x, int y){}
    public static void someMethod(int x, double y){}
//    public static void someMethod(int a, double b){}
//    public static int someMethod(int x, double b){ return 0;}
}

 */
/*
public class Methods {
    public static void main(String[] args) {
        int sum = add(3, 4);
        System.out.println(sum); // 7
        double addition = add(3.0, 4.0);
        System.out.println(addition); // 7.0
    }
    public static int add(int x, int y){
        System.out.println("add(int,int)");
        return x + y;
    }
    public static double add(double x, double y){
        System.out.println("add(double,double)");
        return x + y;
    }
}

 */
/*
public class Methods {
    public static void main(String[] args) {
        performCalc(10, 2, "+");
        int result = performCalc(10, 2, "+"); // method call; passing down "arguments"
        System.out.println(result); // 12
        System.out.println(performCalc(10, 2, "-")); // 8
        System.out.println(performCalc(10, 2, "*")); // 20
        System.out.println(performCalc(10, 2, "/")); // 5
        performCalc(10, 2, "%");// return value ignored
        System.out.println(performCalc(10, 2, "&"));
    }
    public static int performCalc(int x, int y, String operation){  // method "parameters"

        int result = switch(operation){
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "%" -> x % y;
            default -> throw new
                    IllegalArgumentException("Unrecognized operation: "+operation);
        };
        return result;
    }
}
*/

/*
    public static void main(String[] args) {
        // method call; passing down "arguments"
        int result = performCalc(10, 2, "+");
        System.out.println(result);
        System.out.println(performCalc(10, 2, "-"));
        System.out.println(performCalc(10, 2, "*"));
        System.out.println(performCalc(10, 2, "/"));
        System.out.println(performCalc(10, 2, "%"));
        System.out.println(performCalc(10, 2, "&"));
    }
    // method definition/declaration
    public static int performCalc(int x, int y, String operation){//parameters
        int result = switch(operation){
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "%" -> x % y;
            default -> throw new
                    IllegalArgumentException("Unrecognized operation: "+operation);
        };
        return result;
    }

 */
/*
public class Methods {
    public static void main(String[] args) {
        int number = getNumber();
        number = getNumber();
        number = getNumber();
    }
    public static int getNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (1..10) --> ");
        int number = sc.nextInt();
        if(number < 1 || number > 10){
            System.out.println("Invalid number! "+number);
        }
        return number;
    }
}

 */
/*
        System.out.print("Enter a number (1..10) --> ");
        int number = sc.nextInt();
        if(number < 1 || number > 10){
            System.out.println("Invalid number! "+number);
        }

        System.out.print("Enter a number (1..10) --> ");
        number = sc.nextInt();
        if(number < 1 || number > 10){
            System.out.println("Invalid number! "+number);
        }

        System.out.print("Enter a number (1..10) --> ");
        number = sc.nextInt();
        if(number < 1 || number > 10){
            System.out.println("Invalid number! "+number);
        }

 */