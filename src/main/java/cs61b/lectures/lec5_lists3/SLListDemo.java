package cs61b.lectures.lec5_lists3;

public class SLListDemo {

    public static void main(String[] args) {
        SLList<Integer> list = new SLList<>();
        list.addFirst(10);
        list.addLast(20);
        list.addFirst(5);

        System.out.println("First element in the list: " + list.getFirst());
        System.out.println("Size of the list is: " + list.size());

        SLList<String> strList = new SLList<>();
        strList.addFirst("mustard");
        strList.addLast("dijon");

        System.out.println("First element in the string list: " + strList.getFirst());
        System.out.println("Size of the string list is: " + strList.size());
    }
}
