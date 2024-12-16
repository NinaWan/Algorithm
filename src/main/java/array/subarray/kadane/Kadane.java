package array.subarray.kadane;

public class Kadane {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], dp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }

        return ans;
    }
}
