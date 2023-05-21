# Longest Increasing Subsequence

## 解决的问题

求解给定数组的最长递增子序列。

子序列是由原数组删除某些元素后得到的集合。

[LeetCode 300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

## 基本思想

## 实现

### Dynamic Programming

```java
class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n]; // dp[i] - the length of LIS ending at nums[i]

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
```

### Binary Search

```java
class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] lisLast = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int start = 0, end = len;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (lisLast[mid] < num) { // find the first position where value is equal or greater than current num
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            lisLast[start] = num;
            if (start == len) {
                len++;
            }
        }

        return len;
    }
}
```

## 时间复杂度

## 空间复杂度