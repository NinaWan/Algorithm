package sort.quick;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest extends SortTest {
    private QuickSort tested;

    @BeforeEach
    public void setUp() {
        tested = new QuickSort();
    }

    @Test
    public void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}