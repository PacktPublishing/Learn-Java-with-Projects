package ch2;

public class VariablesAndPrimitiveDataTypes {
    public static void main(String[] args) {
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
        byte bin = 0b00010011;   // 19 = 16+2+1
        bin = 0b01111111;   // +127
        System.out.println("0b01111111 == "+bin);
        bin = (byte)0b10000000;   // -128
        System.out.println("(byte)0b10000000 == "+bin);
        bin = 0b01;   // +1
        bin = 0b11;   // +3 (1+2)
        bin = 0b111;   // +7 (1 + 2 + 4)
        bin = 0b1111;   // +15 (1 + 2 + 4 + 8)
        bin = 0b1_1111;   // +31 (1 + 2 + 4 + 8 + 16)
        bin = 0b11_1111;   // +63 (1 + 2 + 4 + 8 + 16 + 32)
        bin = 0b111_1111;   // +127 (1 + 2 + 4 + 8 + 16 + 32 + 64)
        bin = 0b0111_1111;   // +127 (1 + 2 + 4 + 8 + 16 + 32 + 64)
        bin = (byte)0b1111_1111; // -1 (-128 + 127)
        bin = (byte)0b10010011; // -109 (-128 + 19)    1001_0011
        System.out.println("byte == "+bin);
        int i = 0b10010011; // +147 (+128 + 19)  00000000_00000000_00000000_10010011
        System.out.println("int == "+i);
        i = 0b1111_1111; // +255 (+128 + 127)  00000000_00000000_00000000_11111111
        System.out.println("int == "+i);
        i = 0b1000_0000; // 128 00000000_00000000_00000000_10000000
        System.out.println("int == "+i);

        // integral types - have integer values and can be created from
        // integer literals
        byte b9=8;
        char c9=9;
        int i9=9;
        short s9=9;
        long l9=0;
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