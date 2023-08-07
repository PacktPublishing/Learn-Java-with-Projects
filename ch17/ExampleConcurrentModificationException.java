package ch17;

import java.util.HashMap;
import java.util.Map;

public class ExampleConcurrentModificationException {
    public static void main(String[] args) {
        Map<String, String> languageMap = new HashMap<>();
        //ConcurrentMap<String, String> languageMap = new ConcurrentHashMap<>();
        languageMap.put("Maaike", "Java");
        languageMap.put("Seán", "C#");

        for (String key : languageMap.keySet()) {
            System.out.println(key + " loves coding");
            languageMap.remove(key);
        }

    }
}
