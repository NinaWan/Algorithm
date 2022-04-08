package sort.bubble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest extends SortTest {
    private BubbleSort tested;

    @BeforeEach
    public void setUp() {
        tested = new BubbleSort();
        testData = new int[]{3, 2, 1};
        expected = new int[]{1, 2, 3};
    }

    @Test
    void testSort1() {
        tested.sort_1(testData);
        assertArrayEquals(expected, testData);
    }

    @Test
    void testSort2() {
        tested.sort_2(testData);
        assertArrayEquals(expected, testData);
    }
}