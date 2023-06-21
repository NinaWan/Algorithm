package unclassified.sampling;

import java.util.Random;

public class ReservoirSampling {
    private int[] getRandom(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];

        System.arraycopy(nums, 0, res, 0, k);

        for (int i = k; i < n; i++) {
            int random = new Random().nextInt(i + 1);
            if (random < k) {
                res[random] = nums[i];
            }
        }

        return res;
    }
}