package sort.insertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest extends SortTest {
    private InsertionSort tested;

    @BeforeEach
    public void setUp() {
        tested = new InsertionSort();
    }

    @Test
    public void testSort() {
        tested.sort(testData);
        assertArrayEquals(testData, expected);
    }
}