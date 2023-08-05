package ch12;

public class StringTest {













    public static void howManyObjectsString(){
        String s = "The ";
        s += "quick ";           // s = s + "quick "
        System.out.println(s);   // The quick
        s.concat("brown fox");// lost!
        System.out.println(s);   // The quick
        s = s.concat("brown fox");
        System.out.println(s);   // The quick brown fox
    }

    public static void main(String[] args) {
//        String s1 = "abc";                    // string pool
//        String s2 = "abc";                    // string pool
//        System.out.println(s1 == s2);         // true
//        String s3 = new String("abc"); // heap
//        System.out.println(s1 == s3);         // false
//        System.out.println(s1.equals(s2));    // true
//        System.out.println(s1.equals(s3));    // true
//        s3 = s3.intern();
//        System.out.println(s1 == s3);         // true
//        howManyObjectsString();
//        howManyObjectsSB();
        stringAPI();
//        stringBuilderAPI();
    }
    public static void stringBuilderAPI(){
        StringBuilder abc = new StringBuilder("abc");
        StringBuilder def = new StringBuilder("def");
        StringBuilder da  = new StringBuilder("da");
        StringBuilder xyz = new StringBuilder("xyz");
        System.out.println(abc.compareTo(def));   // -3
        System.out.println(def.compareTo(da));    // 4
        System.out.println(xyz.compareTo(xyz));   // 0
    }
    public static void stringAPI(){
        int res = "ace".compareTo("bat");   // -1
        System.out.println(res);
        res = "and".compareTo("at");        // -6
        System.out.println(res);
        res = "bat".compareTo("battle");    // -3
        System.out.println(res);
        res = "xyz".compareTo("xyz");       // 0
        System.out.println(res);

//        System.out.println("abc".endsWith("bc")); // true
//        System.out.println("abc".endsWith("BC")); // false

//        System.out.println("abcdef".indexOf("b"));  // 1
//        System.out.println("abcdef".indexOf("B"));  // -1
//
//        System.out.println("abcdef".length());  // 6

//        System.out.println("abcdef".substring(3)); // def
//        System.out.println("Sean Kennedy".substring(3, 8)); // n Ken
        System.out.println("  lots of  spaces   here    ".trim() + "x");

    }
    public static void howManyObjectsSB(){
        StringBuilder sb = new StringBuilder("The ");
        sb.append("quick ");
        System.out.println(sb);   // The quick
        sb.append("brown fox");
        System.out.println(sb);  // The quick brown fox
    }
}
