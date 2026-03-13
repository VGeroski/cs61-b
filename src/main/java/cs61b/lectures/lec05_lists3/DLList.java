package cs61b.lectures.lec05_lists3;

public class DLList<BleepBlorp> {

    /*        IntNode
        ----------------------
      <-| prev | item | next |->
        ----------------------
     */
    public class IntNode {
        public IntNode prev;
        public BleepBlorp item;
        public IntNode next;

        public IntNode(BleepBlorp item, IntNode next, IntNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private final IntNode sentinel;
    private int size;

    public DLList() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }
}
