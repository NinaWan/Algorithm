package sort.shell;

import sort.ArraySort;

public class ShellSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for (int d = n / 2; d > 0; d /= 2) {
            for (int i = d; i < n; i++) {
                for (int j = i - d; j >= d && nums[j] < nums[j - d]; j -= d) {
                    swap(nums, j, j - d);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
