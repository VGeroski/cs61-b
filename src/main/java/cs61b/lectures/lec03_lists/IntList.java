package cs61b.lectures.lec03_lists;

/** An infinitely long list of Integers. */
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** return the number of items in the list. */
    public int size() {
        if (rest == null) return 1;
        return 1 + rest.size();
    }

    public int iterativeSize() {
        int totalSize = 0;
        IntList p = this;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int iterativeGet(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        int count = 0;
        IntList p = this;
        while (count < index) {
            p = p.rest;
            count++;
        }
        return p.first;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args) {
//        IntList list = new IntList(5,  null);
//        list.rest = new IntList(10, null);
//        list.rest.rest = new IntList(15, null);

        // recursive adding new element at front of list
        IntList L = new IntList(15,  null);
        L = new IntList(10,  L);
        L = new IntList(5,  L);

        System.out.println("Size of the list: " + L.size());
        System.out.println("Size of the list (iterative): " + L.iterativeSize());

        System.out.println("second element is: " + L.get(1));
        System.out.println("second element is: " + L.iterativeGet(1));
    }
}
