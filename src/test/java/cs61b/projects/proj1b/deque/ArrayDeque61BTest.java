package cs61b.projects.proj1b.deque;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArrayDeque61BTest {

    @Test
    void addFirstTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1); // [1]
        ad.addFirst(2); // [2, 1]

        assertThat(ad.get(0)).isEqualTo(2);
        assertThat(ad.get(1)).isEqualTo(1);
        assertThat(ad.get(10)).isEqualTo(null);
        assertThat(ad.size()).isEqualTo(2);
    }

    @Test
    void addLastTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1); // [1]
        ad.addFirst(2); // [2, 1]
        ad.addLast(3);  // [2, 1, 3]
        ad.addFirst(4); // [4, 2, 1, 3]
        ad.addLast(5);  // [4, 2, 1, 3, 5]

        assertThat(ad.get(0)).isEqualTo(4);
        assertThat(ad.get(1)).isEqualTo(2);
        assertThat(ad.get(2)).isEqualTo(1);
        assertThat(ad.get(3)).isEqualTo(3);
        assertThat(ad.get(4)).isEqualTo(5);
    }

    @Test
    void toListTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1); // [1]
        ad.addFirst(2); // [2, 1]
        ad.addLast(3);  // [2, 1, 3]
        ad.addFirst(4); // [4, 2, 1, 3]
        ad.addLast(5);  // [4, 2, 1, 3, 5]

        assertThat(ad.toList()).containsExactly(4, 2, 1, 3, 5).inOrder();
    }

    @Test
    void isEmptyTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        assertThat(ad.isEmpty()).isEqualTo(true);

        ad.addFirst(1);
        assertThat(ad.isEmpty()).isEqualTo(false);
    }

    @Test
    void removeFirstTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1); // [1]
        ad.addFirst(2); // [2, 1]
        ad.addLast(3);  // [2, 1, 3]
        ad.removeFirst();  // [1, 3]
        assertThat(ad.toList()).containsExactly(1, 3).inOrder();

        ad.addFirst(4); // [4, 1, 3]
        ad.addLast(5);  // [4, 1, 3, 5]
        assertThat(ad.toList()).containsExactly(4, 1, 3, 5).inOrder();

        ad.removeFirst();  // [1, 3, 5]
        assertThat(ad.toList()).containsExactly(1, 3, 5).inOrder();
    }

    @Test
    void removeLastTest() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1); // [1]
        ad.addFirst(2); // [2, 1]
        ad.addLast(3);  // [2, 1, 3]
        ad.removeLast();   // [2, 1]
        assertThat(ad.toList()).containsExactly(2, 1).inOrder();

        ad.addFirst(4); // [4, 2, 1]
        ad.addLast(5);  // [4, 2, 1, 5]
        assertThat(ad.toList()).containsExactly(4, 2, 1, 5).inOrder();

        ad.removeLast();  // [4, 2, 1]
        assertThat(ad.toList()).containsExactly(4, 2, 1).inOrder();
    }
}