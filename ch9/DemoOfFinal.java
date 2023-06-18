package ch9;

final class Earth{}
// cannot extend a 'final' class
//class SubEarth extends Earth{}

class Pen{
    final void write(){}
    // 'final' and 'abstract' not allowed together
    // as they have opposite meanings
//    final abstract scribble();
}
class FountainPen extends Pen{
    // cannot override a 'final' method
//    @Override void write(){}
}
public class DemoOfFinal {
    final int ONE_YEAR = 1;
    void print(final String name, final int age){
        // primitives
        //age = age + ONE_YEAR;
        // references - ok to access the object
        System.out.println(name.toUpperCase());
        // references - cannot modify the reference
        //name = "Alexander";

        //ONE_YEAR = 2; // cannot change a constant
    }
}


