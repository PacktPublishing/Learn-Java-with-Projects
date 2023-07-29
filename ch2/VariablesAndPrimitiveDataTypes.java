package ch2;

public class VariablesAndPrimitiveDataTypes {
    public static void integerLiterals(){
        int a = 10;     // decimal
        int b = 0b1010; // binary
        int c = 012;    // octal
        int d = 0xa;    // hexadecimal

        System.out.println(a + ", "+ b + ", "+c+ ", "+d);
    }
    public static void screenOutput(){
        String name = "James";
        int age = 23;
        double salary = 50_000.0;
        // Details: James, 23, 50000.0
        String output = "Details: "+name+", "+age+", "+salary;
        System.out.println(output);
    }
    public static void main(String[] args) {
        screenOutput();
//        integerLiterals();

//        int age = 25;
//        System.out.println(age);

//        int ageOfCar;
//        int numberOfChildren;
//        //char c = 9;
//
//        // valid identifiers
//        int a£€_23, _29, Z, thisIsAnExampleOfAVeryLongVariableName, €2_, $4;

        // invalid identifiers
       /* int 9age;
        int abc def;
        int d
               j;*/

        /*short s1 = 5_000;
        short s2 = 50_000;*/

        // decimal
//        int dec = 30;
//        System.out.println(dec);
//
//        // hexadecimal = 16 + 14
//        int hex = 0x1E;
//        System.out.println(hex);
//
        // binary = 16 + 8 + 4 + 2
        //int bin = 0b11110;
        //System.out.println(bin);
//        byte b = 0b00010011;   // 19 = 16+2+1
//        b = 0b0111_1111;   // +127 (1 + 2 + 4 + 8 + 16 + 32 + 64)
//        System.out.println("0b01111111 == "+b);
//        b = (byte)0b1000_0000;   // -128
//        System.out.println("(byte)0b10000000 == "+b);
//        b = 0b01;   // +1
//        b = 0b11;   // +3 (1+2)
//        b = 0b111;   // +7 (1 + 2 + 4)
//        b = 0b1111;   // +15 (1 + 2 + 4 + 8)
//        b = 0b1_1111;   // +31 (1 + 2 + 4 + 8 + 16)
//        b = 0b11_1111;   // +63 (1 + 2 + 4 + 8 + 16 + 32)
//        b = 0b111_1111;   // +127 (1 + 2 + 4 + 8 + 16 + 32 + 64)
////        System.out.println("byte == "+b);
//        b = (byte)0b1111_1111; // -1 (-128 + 127)
//        b = (byte)0b10010011; // -109 (-128 + 19)    1001_0011
//        System.out.println("(byte)0b10010011 == "+b);
//        int i = 0b10010011; // +147 (+128 + 19)  00000000_00000000_00000000_10010011
//        System.out.println("i == "+i);
//        i = 0b1111_1111; // +255 (+128 + 127)  00000000_00000000_00000000_11111111
//        System.out.println("i == "+i);
//        i = 0b1000_0000; // 128 00000000_00000000_00000000_10000000
//        System.out.println("i == "+i);
//
//        i = 0b10000000_00000000_00000000_00000000; // 0b pattern is viewed an an int, so no cast needed
//        System.out.println("i == "+i);
//        System.out.println("Integer.MIN_VALUE == "+Integer.MIN_VALUE);
//        // integral types - have integer values and can be created from
//        // integer literals
//        byte b9=8;
//        char c9=9;
//        int i9=9;
//        short s9=9;
//        long l9=0;
//
//        int x  = 10;
//        long n = 10L;
//
//        double d = 10.34;
//        float f  = 10.34F;
//
//        char c = 'a';
//
//        boolean b1 = true;
//        boolean b2 = false;
//        float d1 = 1.3e+5f;
//        System.out.println(d1); // 130000.0
//        float d2 = 1.3e-1f;
//        System.out.println(d2); // 0.13

    }
}
/*
        // decimal
        int dec = 30;
        System.out.println(dec);

        // hex = 16 + 14
        int hex = 0x1E;
        System.out.println(hex);

        // binary = 16 + 8 + 4 + 2
        int bin = 0b11110;
        System.out.println(bin);

 */