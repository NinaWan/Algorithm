package sort.counting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest extends SortTest {
    private CountingSort tested;

    @BeforeEach
    void setUp() {
        tested = new CountingSort();
    }

    @Test
    void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}