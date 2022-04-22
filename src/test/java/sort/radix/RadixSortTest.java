package sort.radix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RadixSortTest extends SortTest {
    private RadixLsdSort testedLsd;
    private RadixMsdSort testedMsd;

    @BeforeEach
    void setUp() {
        testedLsd = new RadixLsdSort();
        testedMsd = new RadixMsdSort();
        resetTestData();
    }

    @Test
    void testLsdSort() {
        testedLsd.sort(testData);
        assertArrayEquals(expected, testData);
    }

    @Test
    void testMsdSort() {
        testedMsd.sort(testData);
        assertArrayEquals(expected, testData);
    }
}