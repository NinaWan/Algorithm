package sort.radix;

import java.util.ArrayList;
import java.util.List;

public class RadixLsdSort extends RadixSort {
    @Override
    public void sort(int[] nums) {
        List<List<Integer>> buckets = new ArrayList<>();
        int maxDigitCount = getMaxDigitCount(nums);
        for (int i = 1; i <= maxDigitCount; i++) {// from the least significant digit to the most significant digit
            distribute(nums, 0, nums.length - 1, i, buckets);
            merge(nums, 0, buckets);
        }
    }
}