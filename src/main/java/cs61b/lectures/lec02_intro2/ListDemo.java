package cs61b.lectures.lec02_intro2;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(2));
        list.add(new Dog(155));
        list.add(new Dog(1500));

        for (Dog dog : list) {
            dog.makeNoise();
        }
    }
}
