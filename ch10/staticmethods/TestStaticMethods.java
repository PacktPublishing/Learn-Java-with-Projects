package ch10.staticmethods;

interface I{
//    static void m0(); // missing {}
    static int m1(){return 3;}
}
public class TestStaticMethods implements I{
    public static void main(String[] args) {
//        System.out.println(m1());   //  fails to compile
        System.out.println(I.m1()); // 3
    }
}

