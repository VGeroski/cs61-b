package cs61b.lectures.lec09_inheritance2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDogDemo {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Grigometh", 200));
        dogs.add(new Dog("Pelusa", 5));
        dogs.add(new Dog("Clifford", 9000));

        Dog maxDog = Collections.max(dogs);
        Dog maxDogWithMaximizer = Maximizer.max(dogs.toArray(new Dog[0]));
        System.out.println("Biggest dog is: " + maxDog);
        System.out.println("Biggest dog is: " + maxDogWithMaximizer);

        Comparator<Dog> nc = Dog.NAME_COMPARATOR;
        System.out.println(nc.compare(dogs.get(0), dogs.get(1)));

        // second argument is an object of type Comparator<Dog>
        Dog maxDogName = Collections.max(dogs, Dog.NAME_COMPARATOR);
        System.out.println("max Dog name is: " + maxDogName);

        // lambda comparator
        Comparator<Dog> dc = (d1, d2) -> d1.getName().compareTo(d2.getName());
        maxDogName = Collections.max(dogs, dc);
    }
}
