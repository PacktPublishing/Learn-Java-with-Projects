package ch3;

public class Operators {
    public static void main(String[] args) {

       /* int a = 2 + 3 * 4;
        System.out.println(a);// 14

        int b = 3 + 4 - 2;
        System.out.println(b);

        boolean b1 = false;
        boolean b2;
        boolean b3;
        b3 = b2 = b1;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);*/
/*
        double b = 2.0 * 5.0 / 2.0;
        System.out.println(b);// 5.0
        b = 2.0 * (5.0 / 2.0);
        System.out.println(b);// 5.0
*/
       /* int x=3;
        ++x;
        System.out.println(x);  // 4
        System.out.println(x++);// 4
        System.out.println(x);  // 5

        int y=4;
        y--;
        System.out.println(y);  // 3
        System.out.println(--y);// 2
        System.out.println(y);  // 2*/

        /*int x = +6;
        int y = -x;
        System.out.println(x);  // 6
        System.out.println(y);  // -6

        int z = (int)3.45;
        System.out.println(z);  // 3

        boolean b = true;
        System.out.println(!b); // false
        System.out.println(b);  // true*/

/*
        int res = 6 + 4 - 2;
        System.out.println(res); // 8
*/
/*
        System.out.println(10/3); // 3
*/
        /*int mod1 = 10 % 3;
        System.out.println(mod1); // 1
        int mod2 = 0 % 3;
        System.out.println(mod2); // 0*/

       /* int res = 3 + 2 * 4;
        System.out.println(res); // 11
        res = (3 + 2) * 4;
        System.out.println(res); // 20
        res = 6 + 4 - 2;
        System.out.println(res); // 8
        res = 10 / 4 * 6 % 10;
        System.out.println(res); // 2
*/
/*        byte b1=2, b2=3;
        byte b3 = b1 + b2; // compiler error
        byte b4 = (byte)(b1 + b2);*/

/*
        String s = "3" + 4;
        System.out.println(s); // "34"
*/
      /*  int a=3, b=2;
        int res = a + b;
        System.out.println(res); // 5
        String s = "abc";
        String s1 = a + s;  // "3abc"
        String s2 = s + a;  // "abc3"
        System.out.println(s1 + " " + s2); // "3abc abc3"

        System.out.println("Output is "+ a + b); // "Output is 32"
        System.out.println("Output is "+ (a + b)); // "Output is 5"*/

       /* int x=3, y=4;
        System.out.println(x == y); // false
        System.out.println(x != y); // true
        System.out.println(x > y);  // false
        System.out.println(x >= y); // false
        System.out.println(x < y);  // true
        System.out.println(x <= y); // true
*/
      /*  System.out.println(3 + 4.0);  // 7.0
        System.out.println(4 == 4.0); // true*/


 /*       boolean b1 = false, b2 = true;
        boolean res = b1 && ((b2=false)); // F &&
        System.out.println(b1 + " " + b2 + " " + res);// false true false
*/

       /* boolean a=false, b=false, c=false;
        // a || (b && c)
        boolean bool = (a = true) || (b = true) && (c = true); // T ||
        System.out.print(a + ", " + b + ", " + c); // true, false, false

        int x=2, y=3, z=4;
        int res = x + y * z;    // a + (b * c)
        System.out.println(res);// 14*/

/*
        boolean b1=false, b2=true;
        boolean res = b2 || (b1=true);  // T ||
        System.out.println(b1 + " "+ b2 + " "+res);// false true true
*/
/*
        boolean b1 = false, b2 = true;
        boolean res = b1 & (b2=false); // F & F
        System.out.println(b1 + " " + b2 + " " + res);// false false false
*/
/*
        boolean b1=false, b2=true;
        boolean res = b2 | (b1=true);  // T | T
        System.out.println(b1 + " "+ b2 + " "+res);// true true true
*/
/*        boolean b1 = (5 > 1) ^ (10 < 20);   // T ^ T == F
        boolean b2 = (5 > 10) ^ (10 < 20);  // F ^ T == T
        boolean b3 = (5 > 1) ^ (10 < 2);    // T ^ F == T
        boolean b4 = (5 > 10) ^ (10 < 2);   // F ^ F == F
        // false true true false
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);*/

/*
        byte b1 = 6 & 8;        // both bits must be 1
        byte b2 = 7 | 9;        // one or the other or both
        byte b3 = 5 ^ 4;        // one or the other but not both
        System.out.println(b1 + " " + b2 + " "+b3); // 0 15 1
*/
/*
        int x = 4;
        String s = x % 2 == 0 ? " is an even number" : " is an odd number";
        System.out.println(x + s); // 4 is an even number
*/
/*        byte b1 = 3, b2 = 4;
//        b1 = b1 + b2; // compiler error
        b1 = (byte)(b1 + b2); // ok
        b1 += b2; // ok, no cast required*/

/*
        int x = 2;
        x *= 2 + 5; // x = x * (2 + 5) = 2 * 7 = 14
        System.out.println(x); // 14
*/
        int k=1;
        k += (k=4) * (k+2);
        System.out.println(k); // 25
    }

}
