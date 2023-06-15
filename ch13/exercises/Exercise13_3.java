package ch13.exercises;

public class Exercise13_3 {
}

class Crate<T> {
    private T item;

    public void store(T item) {
        this.item = item;
    }

    public T retrieve() {
        return item;
    }
}
