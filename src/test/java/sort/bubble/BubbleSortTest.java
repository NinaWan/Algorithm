package sort.bubble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest extends SortTest {
    private BubbleSort bubbleSort;

    @BeforeEach
    public void setup() {
        bubbleSort = new BubbleSort();
        tested = new int[]{3, 2, 1};
        expected = new int[]{1, 2, 3};
    }

    @Test
    void testSort1() {
        bubbleSort.sort_1(tested);
        assertArrayEquals(tested, expected);
    }

    @Test
    void testSort2() {
        bubbleSort.sort_2(tested);
        assertArrayEquals(tested, expected);
    }
}