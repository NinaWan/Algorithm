package sort.shell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.SortTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest extends SortTest {
    private ShellSort tested;

    @BeforeEach
    void setUp() {
        tested = new ShellSort();
    }

    @Test
    void testSort() {
        tested.sort(testData);
        assertArrayEquals(expected, testData);
    }
}