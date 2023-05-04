package ch7;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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