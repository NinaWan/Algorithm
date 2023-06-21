# Boyer–Moore Majority Vote Algorithm

## 解决的问题

求解一组数据中的众数。

[LeetCode 229. Majority Element II](https://leetcode.com/problems/majority-element-ii)

## 基本思想

## 实现

```java
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
class BoyerMooreMajority {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList();

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        if (candidate2 != candidate1 && count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}
```

## 时间复杂度

O(n)

## 空间复杂度

O(1)