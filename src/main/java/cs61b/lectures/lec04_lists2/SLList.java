package cs61b.lectures.lec04_lists2;

/** Singly linked list of numbers, that has nodes (IntNode) */
public class SLList {
    // since IntNode will be used only for this class
    // we can make IntNode to be nested
    private static class IntNode {
        int item;
        IntNode next;

        IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    // the sentinel node is the dummy node at the front of the list
    // and the real first item is sentinel.next (if it exists)
    private final IntNode sentinel;
    private int size;

    /** Construct empty list */
    public SLList() {
        // we just create dummy node, item is not important
        // this is still an empty list
        this.sentinel = new IntNode(-1, null);
        this.size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-1, null); // dummy node
        sentinel.next = new IntNode(x, null); // real first node
        size += 1;
    }

    void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(int x) {
        // guard if list is empty
//        no need for guard after adding sentinel node
//        if (sentinel == null) {
//            addFirst(x);
//            return;
//        }

        IntNode p = sentinel;

        // advance p until it is the last item
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
        size += 1;
    }

    public int size() {
        // return size(sentinel.next);
        return size;
    }

    /**
     * This function returns the size of the
     * naked recursive list starting at node p
     * @param p node
     * @return size
     */
    private int size(IntNode p) {
        if (p == null) return 0;
        return 1 + size(p.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }
}
