package sort;

public class SortTest {
    protected int[] testData = {1, 1, 8, 7, 44, 42, 46, 38, 34, 33, 17, 15, 16, 27, 28, 24};
    protected int[] expected = {1, 1, 7, 8, 15, 16, 17, 24, 27, 28, 33, 34, 38, 42, 44, 46};

    protected void resetTestData() {
        testData = new int[]{1, 1, 8, 7, 44, 42, 46, 38, 34, 33, 17, 15, 16, 27, 28, 24};
    }
}