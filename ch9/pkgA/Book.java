package ch9.pkgA;

public class Book {
    protected void read(){}
}
class NonFictionBook extends Book{
    public void doThings(){
        read(); // same package; no problem
    }
}
class Magnifier{
    void magnify(){
        Book b = new Book();
        b.read(); // same package; no problem
    }
}

