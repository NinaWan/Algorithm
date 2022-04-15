package sort.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest extends SortTest {
    private HeapSort tested;

    @BeforeEach
    void setUp() {
        tested = new HeapSort();
    }

    @Test
    void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}