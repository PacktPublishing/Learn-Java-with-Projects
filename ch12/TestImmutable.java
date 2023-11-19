package ch12;

import java.util.ArrayList;
import java.util.List;

final class Farm { // cannot subclass this class and all methods are final
    // private final instance variables
    private final String name; // String is immutable
    private final int numAnimals;
    private final List<String> animals;// mutable
    
    // private constructor
    private Farm(final String name, final int numAnimals, final List<String> animals){
        this.name           = name;
        this.numAnimals     = numAnimals;
        this.animals      = new ArrayList<String>(animals); // create a new ArrayList
//        this.animals        = animals; // breaking encapsulation!
    }
    // factory method to create a Farm
    public static Farm createNewInstance(String name, int numAnimals,
                                         List<String> animals){
        return new Farm(name, numAnimals, animals);
    }
    // no 'set' methods, only 'get' methods
    public String getName(){
        return name;
    }
    public int getNumAnimals(){
        return numAnimals;
    }
    public List<String> getAnimals(){
        return new ArrayList<String>(animals);  // return a new object
//        return animals;  // breaking encapsulation!
    }
    @Override
    public String toString() {
        return "Farm{" + "name=" + name + ", numAnimals=" +
                numAnimals + ", animals=" + animals + '}';
    }
}

 //1. The next line generates the error:
 //   - "compiler error: cannot inherit from Farm" as Farm is final
//class DairyFarm extends Farm{
//    DairyFarm(){
//        // 2. The next line generates the error:
//        //    - Farm constructor is not visible
//        super("", "", 2, new ArrayList<String>());
//    }
//}

public class TestImmutable {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cattle");
        
        Farm farm = Farm.createNewInstance("Small Farm", 25, animals);
        System.out.println("Created: "+farm); // Created: Farm{name=Small Farm, numAnimals=25, animals=[Cattle]}

        // Get the instance variables
        String name    = farm.getName();
        int numAnimals = farm.getNumAnimals();
        animals        = farm.getAnimals();
        System.out.println("Retrieved: "+name+" "
                +" "+numAnimals+ " "+animals); // Retrieved: Small Farm  25 [Cattle]
        
        // change what I got back - any affect on the "farm" immutable object?
        name = "Big Farm";// Strings are immutable so new objects are created in the background => OK
        numAnimals = 500; // simple primitive i.e. value is just copied back
        animals.add("Sheep");animals.add("Horses");  // safe or unsafe ?

        // Any change?: Farm{name=Small Farm, numAnimals=25, animals=[Cattle, Sheep, Horses]}
        System.out.println("Any change?: "+farm);
    }    
}
