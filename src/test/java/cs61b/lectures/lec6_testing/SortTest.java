package cs61b.lectures.lec6_testing;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class SortTest {

    @Test
    public void testSort() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        String[] expected = {"a", "newway", "rawr", "zaza"};
        Sort.sort(input);

        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        int expected = 1;

        int actual = Sort.findSmallest(input, 0);
        assertThat(actual).isEqualTo(expected);

        expected = 3;
        actual = Sort.findSmallest(input, 2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSwap() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        String[] expected = {"rawr", "newway", "zaza", "a"};
        Sort.swap(input, 1, 3);

        assertThat(input).isEqualTo(expected);
    }

}