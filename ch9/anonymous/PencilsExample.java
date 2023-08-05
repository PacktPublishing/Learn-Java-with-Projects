package ch9.anonymous;

public class PencilsExample {
    public static void main(String[] args) {
        // Anonymous inner class implementation
        Pencil pp    = new Pencil() {
            @Override
            void write() {
                System.out.println("write()");
            }
        };
        pp.write(); // outputs: write()
    }
}
