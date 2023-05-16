package ch8;

class Tag{}
public class Cow {
    Tag tag;
    String country;

    public static void main(String[] args) {
        Cow cow1 = new Cow();
        Cow cow2 = cow1;// reassignment
        cow2.tagAnimal(cow1);
    }
    void tagAnimal(Cow cow){
        tag = new Tag();
        cow.setCountry("France");
    }
    void setCountry(String country){
        this.country = country;
    }
}

