package ch15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeclarativeStyle {
    public static void main(String[] args) {
        var listCities = List.of("Dublin", "Antwerp", "Boston", "Seattle", "Miami");

        // imperative-style
        List<String> filteredCityList = new ArrayList<>();
        for(String city:listCities){
            if(city.length() == 6) filteredCityList.add(city);
        }
        Collections.sort(filteredCityList);
        var iterator = filteredCityList.iterator();
        if(iterator.hasNext()) System.out.println(iterator.next());
        if(iterator.hasNext()) System.out.println(iterator.next());

        // declarative-style
        listCities.stream()
                .filter(city -> city.length() == 6)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
    }
}
