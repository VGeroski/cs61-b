package cs61b.lectures.lec02_intro2;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> L = new TreeMap<>();
        L.put("dog", "woof");
        L.put("cat", "meow");

        System.out.println(L.get("cat"));
    }
}
