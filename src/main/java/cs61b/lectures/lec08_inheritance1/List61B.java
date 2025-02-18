package cs61b.lectures.lec08_inheritance1;

// This cannot be instated directly because it is interface
public interface List61B<Item> {
    void insert(Item x, int position);
    void addFirst(Item x);
    void addLast(Item x);
    Item getFirst();
    Item getLast();
    Item get(int i);
    int size();
    Item removeLast();

    default void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
    }
}