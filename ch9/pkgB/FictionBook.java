package ch9.pkgB;

import ch9.pkgA.Book;

class FictionBook extends Book{
    public void doThings(){
        read();     // different package, via inheritance; no problem
        this.read();// different package, via inheritance; no problem
        FictionBook fb = new FictionBook(); // default ctor created for us
        fb.read();  // no problem
        
        // Here, I create an instance of the superclass that has the protected
        // member. Note that even though FictionBook has access via inheritance
        // to read(), FictionBook must access it properly.
        Book b = new Book();
//        b.read();   // not public!
    }
}
class SpaceFictionBook extends FictionBook{
    public void doThings(){
        read();     // different package, via inheritance; no problem
//        new Book().read();
//        new FictionBook().read();
        new SpaceFictionBook().read();// ok
    }
}
class Reader{
    public void doThings(){
        Book b = new Book();
//        b.read();
        
        // can I access the protected member via the subclass that inherits it?
        FictionBook fb = new FictionBook(); 
//        fb.read();
    }
}



