package cs61b.lectures.lec02_intro2;

public class Dog {
    public int weightInPounds;

    public Dog(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyipyip!");

        } else if(weightInPounds > 30) {
            System.out.println("bark. bark.");

        } else {
            System.out.println("woof!");
        }
    }

    /* Compare myself to other dog */
    public Dog maxDog(Dog otherDog) {
        if (this.weightInPounds > otherDog.weightInPounds) {
            return this;
        }
        return otherDog;
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
}
