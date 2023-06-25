package ch10.privatemethods;

interface InefficientTennis{
    // Lots of code duplication here.
    static void forehand(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into ready position");
    }
    default void backhand(){
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back into ready position");
    }
    default void smash(){
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back into ready position");
    }
}

interface EfficientTennis{
    // encapsulated within the interface
    private static void hit(String stroke){
        System.out.println("Move into position");
        System.out.println("Hitting a "+stroke);
        System.out.println("Move back into ready position");
    }
    default void backhand(){ hit("backhand"); }
    static void forehand(){
//        smash();// static to instance not allowed!
        hit("forehand");
    }
    private void smash(){ hit("smash"); }
//    void volley(){ hit("volley"); } // abstract by default
}

// No abstract methods to implement.
public class SportTest implements EfficientTennis{
    public static void main(String[] args) {
        new SportTest().backhand();
        EfficientTennis.forehand();
//        new SportTest().hit();      // encapsulated
    }
}



