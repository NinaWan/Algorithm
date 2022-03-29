package sort.selection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest extends SortTest {
    private SelectionSort tested;

    @BeforeEach
    public void setup() {
        tested = new SelectionSort();
    }

    @Test
    public void testSort() {
        tested.sort(testData);
        assertArrayEquals(testData, expected);
    }
}