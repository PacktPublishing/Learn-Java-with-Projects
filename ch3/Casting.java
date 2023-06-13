package ch3;

public class Casting {
    public static void main(String[] args) {
/*
        System.out.println("Float: " + Float.MAX_VALUE);// Float: 3.4028235E38
        System.out.println("Float: " + Float.MIN_VALUE);// Float: 1.4E-45
        System.out.println("Long: " + Long.MAX_VALUE);  // Long: 9223372036854775807
        System.out.println("Long: " + Long.MIN_VALUE);  // Long: -9223372036854775808
*/
        // Widening
//        final byte b = 5;
//        char c = b;
/*
        char c   = 'a'; // normal
        int i    = c;   // widening, char to int
        float f  = i;   // widening, int to float
        double d = f;   // widening, float to double
        float f2 = 1L;  // widening, long to float
*/

        // Narrowing
      /*  int i   = (int)3.3;                         // narrowing, double to int
        byte b  = (byte) 233;                       // narrowing, int to byte
        float f = (float) 3.5;                      // narrowing, double to float
        System.out.println(i + " " + b + " " +f);   // 3 -23 3.5*/

        // Special Rules for byte,char,short and int

//        byte b  = 127;          // narrowing, int to byte, special rule integral
//        byte b2 = 128;          // out of range error
        char c = 12;
        // incompatible types: possible lossy conversion from int to char
        // char c2 = 90_000;
        short s = 12;           // 12 is a literal, ok
        // incompatible types: possible lossy conversion from char to short
        // s = c;
        s = (short) c;
        // incompatible types: possible lossy conversion from short to char
        // c = s;
        c = (char) s;

        final char c1 = 12;
        short s1 = 12;           // 12 is a literal, ok
        s1 = c1;
    }
}
