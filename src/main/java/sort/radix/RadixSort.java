package sort.radix;

import sort.ArraySort;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
    }

    protected int getMaxDigitCount(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return getDigitCount(max);
    }

    protected int getDigitCount(int num) {
        return String.valueOf(num).length();
    }

    protected int getDigit(int num, int i) {
        return (int) (num / Math.pow(10, i - 1)) % 10;
    }

    protected void initBuckets(List<List<Integer>> buckets) {
        buckets.clear();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    protected void distribute(int[] nums, int left, int right, int d, List<List<Integer>> buckets) {
        initBuckets(buckets);
        for (int i = left; i <= right; i++) {
            int digit = getDigit(nums[i], d);
            buckets.get(digit).add(nums[i]);
        }
    }

    protected void merge(int[] nums, int start, List<List<Integer>> buckets) {
        int i = start;
        for (List<Integer> bucket : buckets) {
            if (bucket.isEmpty()) {
                continue;
            }

            for (int num : bucket) {
                nums[i++] = num;
            }
        }
    }
}
