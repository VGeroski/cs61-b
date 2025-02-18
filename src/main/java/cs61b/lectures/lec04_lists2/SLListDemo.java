package cs61b.lectures.lec04_lists2;

public class SLListDemo {

    public static void main(String[] args) {
        SLList list = new SLList();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);

        System.out.println("First element in the list: " + list.getFirst());
        System.out.println("Size of the list is: " + list.size());
    }
}
