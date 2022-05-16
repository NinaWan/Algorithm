package sort.tim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TimSortTest extends SortTest {
    private TimSort tested;

    @BeforeEach
    void setUp() {
        tested = new TimSort();
    }

    @Test
    void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}