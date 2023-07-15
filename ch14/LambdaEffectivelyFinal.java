package ch14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
public class LambdaEffectivelyFinal {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        people.add ("Mr. John Bloggs");people.add ("Ms. Ann Bloggs");
        people.add ("Mr. Mike Bloggs");people.add ("Ms. Mary Bloggs");

        String title="Mr."; // final or effectively final
        int y = 0;
        y++; // no issue, 'y' is not used in lambda

        // Lambdas take a snapshot/picture of local variables; these local
        // variables MUST NOT change. Only setting up lambda here.
        Predicate<String> lambda = str -> {
            //title = "Miss;
            return str.startsWith(title); // "Mr."
        };

        // If 'title' was allowed to change, then the method and the lambda would
        // have 2 different views of 'title'!
        //title = "Ms";
        filterData(people, lambda);// lambda views 'title' as "Mr."

        //title = "Ms";
        filterData(people, lambda);// lambda views 'title' as "Mr."
    }
    public static void filterData(List<String> list, Predicate<String> lambda){
        list.removeIf(lambda); // only executing lambda here!
    }
}
/*
//        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
//            String s = iterator.next();
//            if(lambda.test(s)){
//                iterator.remove();
//            }
//        }

//        for(String s:list){ // ConcurrentModificationException
//            if(lambda.test(s)){
//                list.remove(s);
//            }
//        }
        System.out.println(people);

 */