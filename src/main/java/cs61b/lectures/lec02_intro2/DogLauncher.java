package cs61b.lectures.lec02_intro2;

public class DogLauncher {

    public static void main(String[] args) {
        Dog maya = new Dog(9);
        maya.makeNoise();

        Dog greg = new Dog(20);
        greg.makeNoise();

        Dog larger = Dog.maxDog(maya, greg);
        larger.makeNoise();

        Dog larger2 = maya.maxDog(larger);
        larger2.makeNoise();
    }
}
