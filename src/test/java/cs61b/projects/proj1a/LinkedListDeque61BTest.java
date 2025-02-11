package cs61b.projects.proj1a;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class LinkedListDeque61BTest {
     @Test
     /** In this test, we have three different assert statements that verify that addFirst works correctly. */
     public void addFirstTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addFirst("back"); // after this call we expect: ["back"]
         assertThat(lld1.toList()).containsExactly("back").inOrder();

         lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
         assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

         lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
      *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
     public void addLastTestBasic() {
         Deque61B<String> lld1 = new LinkedListDeque61B<>();

         lld1.addLast("front"); // after this call we expect: ["front"]
         lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
         lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
         assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
     }

     @Test
     /** This test performs interspersed addFirst and addLast calls. */
     public void addFirstAndAddLastTest() {
         Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
         lld1.addLast(0);   // [0]
         lld1.addLast(1);   // [0, 1]
         lld1.addFirst(-1); // [-1, 0, 1]
         lld1.addLast(2);   // [-1, 0, 1, 2]
         lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

         assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
     }

    @Test
    public void isEmptyTest() {
        Deque61B<String> lld = new LinkedListDeque61B<>();
        assertThat(lld.isEmpty()).isTrue();
    }

    @Test
    public void isNotEmptyTest() {
        Deque61B<String> lld = new LinkedListDeque61B<>();
        lld.addFirst("front");
        assertThat(lld.isEmpty()).isFalse();
    }

    @Test
    public void getTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();

        lld.addLast(0);   // [0]
        lld.addLast(1);   // [0, 1]
        lld.addFirst(-1); // [-1, 0, 1]
        lld.addLast(2);   // [-1, 0, 1, 2]
        lld.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld.get(0)).isEqualTo(-2);
        assertThat(lld.get(1)).isEqualTo(-1);
        assertThat(lld.get(2)).isEqualTo(0);
        assertThat(lld.get(4)).isEqualTo(2);
        assertThat(lld.get(5)).isEqualTo(null);
    }

    @Test
    public void getRecursiveTest() {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();

        lld.addLast(0);   // [0]
        lld.addLast(1);   // [0, 1]
        lld.addFirst(-1); // [-1, 0, 1]
        lld.addLast(2);   // [-1, 0, 1, 2]
        lld.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld.getRecursive(0)).isEqualTo(-2);
        assertThat(lld.getRecursive(1)).isEqualTo(-1);
        assertThat(lld.getRecursive(2)).isEqualTo(0);
        assertThat(lld.getRecursive(4)).isEqualTo(2);
        assertThat(lld.getRecursive(5)).isEqualTo(null);
    }

    @Test
    public void removeFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

        String res = lld1.removeFirst(); // ["middle", "back"]
        assertThat(res).isEqualTo("front");
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();
        assertThat(lld1.size()).isEqualTo(2);

        lld1.addFirst("front");
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void removeLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("front");
        lld1.addFirst("middle");
        lld1.addFirst("back");
        assertThat(lld1.toList()).containsExactly("back", "middle", "front").inOrder();

        String res = lld1.removeLast();
        assertThat(res).isEqualTo("front");
        assertThat(lld1.toList()).containsExactly("back", "middle").inOrder();
        assertThat(lld1.size()).isEqualTo(2);

        lld1.addLast("item1");
        lld1.addLast("last");
        assertThat(lld1.toList()).containsExactly("back", "middle", "item1", "last").inOrder();
        res = lld1.removeLast();
        assertThat(res).isEqualTo("last");
        assertThat(lld1.toList()).containsExactly("back", "middle", "item1").inOrder();

        res = lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly("middle", "item1").inOrder();
    }
}