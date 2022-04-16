package sort.bubble;

import sort.ArraySort;

public class BubbleSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // sort with flag
    public void sortWithFlag(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            boolean sorted = true;

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
