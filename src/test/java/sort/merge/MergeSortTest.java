package sort.merge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest extends SortTest {
    private MergeSort tested;

    @BeforeEach
    public void setUp() {
        tested = new MergeSort();
    }

    @Test
    public void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}