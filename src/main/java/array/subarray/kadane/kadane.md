# Kadane算法

## 解决的问题

给定一个数组，求它的最大子数组和(Maximum Subarray)。

子数组是数组中的一个连续部分。

[LeetCode 53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)

## 基本思想

该算法的基本思想是假设已知nums[0...i]的最大子数组和为dp，那么nums[0...i+1]的最大子数组和应该是多少呢？

答案是max(dp+nums[i+1], nums[i+1])。

那么，就可以依次遍历数组中的每一个位置，求出以当前位置为结尾的子数组和的最大值是多少，然后求一个全局最大值即是整个数组的最大子数组和。

## 实现

```java
class Kadane {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], dp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }

        return ans;
    }
}
```

## 时间复杂度

O(n)