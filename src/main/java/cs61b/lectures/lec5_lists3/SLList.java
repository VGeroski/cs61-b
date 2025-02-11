package cs61b.lectures.lec5_lists3;

/** Singly linked list of numbers, that has nodes (Mustard - generic type) */
public class SLList<Mustard> {
    // since IntNode will be used only for this class
    // we can make IntNode to be nested
    private class MustardNode {
        Mustard item;
        MustardNode next;

        MustardNode(Mustard item, MustardNode next) {
            this.item = item;
            this.next = next;
        }
    }

    // the sentinel node is the dummy node at the front of the list
    // and the real first item is sentinel.next (if it exists)
    private final MustardNode sentinel;
    private int size;

    /** Construct empty list */
    public SLList() {
        // we just create dummy node, item is not important
        // this is still an empty list
        this.sentinel = new MustardNode(null, null);
        this.size = 0;
    }

    public SLList(Mustard x) {
        sentinel = new MustardNode(x, null); // dummy node
        sentinel.next = new MustardNode(x, null); // real first node
        size += 1;
    }

    void addFirst(Mustard x) {
        sentinel.next = new MustardNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(Mustard x) {
        MustardNode p = sentinel;

        // advance p until it is the last item
        while (p.next != null) {
            p = p.next;
        }

        p.next = new MustardNode(x, null);
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
    private int size(MustardNode p) {
        if (p == null) return 0;
        return 1 + size(p.next);
    }

    public Mustard getFirst() {
        return sentinel.next.item;
    }
}
