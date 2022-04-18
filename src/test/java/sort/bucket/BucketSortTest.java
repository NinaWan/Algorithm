package sort.bucket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BucketSortTest extends SortTest {
    private BucketSort tested;

    @BeforeEach
    void setUp() {
        tested = new BucketSort();
    }

    @Test
    void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}