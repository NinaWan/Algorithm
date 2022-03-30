package sort.merge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest extends SortTest {
    private MergeSort tested;

    @BeforeEach
    public void setup() {
        tested = new MergeSort();
    }

    @Test
    public void testSort() {
        tested.sort(testData, 0, testData.length - 1);
        assertArrayEquals(expected, testData);
    }
}