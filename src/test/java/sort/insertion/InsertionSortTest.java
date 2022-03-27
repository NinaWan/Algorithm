package sort.insertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest extends SortTest {
    private InsertionSort insertionSort;

    @BeforeEach
    public void setup() {
        insertionSort = new InsertionSort();
    }

    @Test
    public void testSort() {
        insertionSort.sort(tested);
        assertArrayEquals(tested, expected);
    }
}