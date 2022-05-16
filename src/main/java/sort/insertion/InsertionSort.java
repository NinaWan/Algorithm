package sort.insertion;

import sort.ArraySort;

public class InsertionSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void sort_binary(int[] nums) {
        sort_binary(nums, 0, nums.length);
    }

    public void sort_binary(int[] nums, int left, int right) {// left inclusive, right exclusive
        sort_binary(nums, left, right, left + 1);
    }

    public void sort_binary(int[] nums, int left, int right, int start) {// start - the index of the start of unsorted area
        for (int i = start; i < right; i++) {
            int low = left, high = i - 1;
            while (low <= high) {// binary search where to insert current value
                int mid = low + (high - low) / 2;
                if (nums[mid] <= nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            int tmp = nums[i];
            if (i - low >= 0) {// one-time movement
                System.arraycopy(nums, low, nums, low + 1, i - low);
            }
            nums[low] = tmp;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
