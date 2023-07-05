package ch12;

public class StringVersusStringBuilder {
    public static void whatHappens(String s, StringBuilder sb){
        s = s.concat(" there!");
        sb.append(" there!");
        System.out.println("whatHappens: "+s);  // Hi there!
        System.out.println("whatHappens: "+sb); // Hi there!
    }
    public static void main(String[] args) {
        String s = "Hi";
        StringBuilder sb = new StringBuilder("Hi");
        whatHappens(s, sb);
        System.out.println("main: "+s);  // Hi
        System.out.println("main: "+sb); // Hi there!
    }
}
