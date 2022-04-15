package sort.heap;

public class HeapSort {

    public void sort(int[] nums) {
        buildMaxHeap(nums);

        for (int i = nums.length - 1; i > 0; i--) {// sort data
            swap(nums, 0, i);// swap the first and last elements in the max heap
            maxHeapify(0, nums, i - 1);// sink from top element
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {// for each non-leaf node
            maxHeapify(i, nums, n);
        }
    }

    private void maxHeapify(int i, int[] nums, int n) {
        int left = i * 2 + 1, right = i * 2 + 2, max = left;

        if (left >= n) {// node i doesn't have any child node
            return;
        }

        if (right < n && nums[right] > nums[left]) {// update max if right child node is greater than left child node
            max = right;
        }

        if (nums[max] > nums[i]) {// if child node is greater than parent node
            swap(nums, i, max);
            maxHeapify(max, nums, n);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
