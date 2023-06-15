package ch9;

abstract class Pencil{
    abstract void write(); // no {}
}
//class CharcoalPencil extends Pencil{}
abstract class WaterColorPencil extends Pencil{}
class GraphitePencil extends Pencil{
    @Override
    void write(){
        System.out.println("GraphitePencil::write()");
    }
}

public class PencilsExample{
    public static void main(String[] args) {
//        Pencil pp    = new Pencil(); // cannot "new" a Pencil (abstract)
        Pencil pdp   = new GraphitePencil();
        pdp.write();    // GraphitePencil::write()
    }
}


/* Saving
abstract class Pen {}// no abstract methods
abstract class Pencil{
    abstract void write(); // no {}
}
class DrawingPencil extends Pencil{
    void write(){}
    void erase(){}
}

public class PenExample{
    public static void main(String[] args) {
//        Pen pen         = new Pen(); // cannot "new" a Pen (abstract)
        Pencil pencil   = new DrawingPencil();
//        pencil.erase();
        DrawingPencil dp = (DrawingPencil)pencil;
        dp.erase();
    }
}

 */