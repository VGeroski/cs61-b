package cs61b.lectures.lec1_intro;

public class LargerDemo {
    public static void main(String[] args) {
        System.out.println(larger(3, 5));
        // System.out.println(larger("cat", "zebra")); // won't work directly (we need Comparable with generics)
    }

    private static int larger(int x, int y) {
        if (x > y) { return x; }
        return y;
    }
}
