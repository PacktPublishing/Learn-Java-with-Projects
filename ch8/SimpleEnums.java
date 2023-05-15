package ch8;

enum Water {
    STILL, SPARKLING;
}
public class SimpleEnums {
    public static void main(String[] args) {
//        Water stillWater = new Water();// compiler error
//        Water stillWater = Water.EXTRA_SPARKLING; // type safety

        Water stillWater = Water.STILL;
        System.out.println(stillWater == Water.STILL);        // true
        System.out.println(stillWater.equals(Water.STILL));   // true
        switch(stillWater){
            case STILL:
                System.out.println("Still water");
                break;
//            case Water.STILL: // unqualified enum value required
//            case 0: // cannot use an int
        }
//        if(Water.STILL == 0){}// Water == int
        Water sparklingWater = Water.valueOf("SPARKLING");
        System.out.println(sparklingWater);// SPARKLING

        for(Water water: Water.values()){
            // Ordinal value of: 0 is STILL
            // Ordinal value of: 1 is SPARKLING
            System.out.println("Ordinal value of: "+ water.ordinal() + " is "+ water.name());
        }

    }
}

