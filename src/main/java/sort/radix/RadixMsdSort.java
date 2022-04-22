package sort.radix;

import java.util.ArrayList;
import java.util.List;

public class RadixMsdSort extends RadixSort {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1, getMaxDigitCount(nums));
    }

    private void sort(int[] nums, int left, int right, int i) {
        if (right <= left || i < 1) {
            return;
        }

        List<List<Integer>> buckets = new ArrayList<>();
        distribute(nums, left, right, i, buckets);
        merge(nums, left, buckets);

        int count = left;
        for (List<Integer> bucket : buckets) {// recursively sort non-empty buckets
            if (!bucket.isEmpty()) {
                sort(nums, count, count + bucket.size() - 1, i - 1);
            }
            count += bucket.size();
        }
    }
}
