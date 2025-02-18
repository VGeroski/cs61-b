package cs61b.lectures.lec04_lists2;

/** Instead of naked IntList, we refactor class to be IntNode, without functionality */
public class IntNodeExample {
    public int item;
    public IntNodeExample next;

    public IntNodeExample(int item, IntNodeExample next) {
        this.item = item;
        this.next = next;
    }
}
