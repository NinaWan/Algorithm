package sort.quick;

public class QuickSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIdx = partition(nums, start, end);
        sort(nums, start, pivotIdx - 1);
        sort(nums, pivotIdx + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start], left = start, right = end;

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = pivot;

        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
