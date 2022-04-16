package sort.selection;

import sort.ArraySort;

public class SelectionSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }

            swap(nums, i, minIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
