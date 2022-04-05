package sort.merge;

public class MergeSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);

        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] res = new int[end - start + 1];
        int l = start, r = mid + 1, i = 0;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                res[i++] = nums[l++];
            } else {
                res[i++] = nums[r++];
            }
        }

        while (l <= mid) {
            res[i++] = nums[l++];
        }

        while (r <= end) {
            res[i++] = nums[r++];
        }

        System.arraycopy(res, 0, nums, start, end - start + 1);
    }
}
