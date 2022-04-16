package sort.counting;

public class CountingSort {
    public void sort(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

//        // Unstable version
//        for (int i = 0, j = 0; j < count.length; j++) {
//            while (count[j] > 0) {
//                nums[i++] = j + min;
//                count[j]--;
//            }
//        }

        // Stable version
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[--count[nums[i] - min]] = nums[i];
        }

        System.arraycopy(sorted, 0, nums, 0, n);
    }
}
