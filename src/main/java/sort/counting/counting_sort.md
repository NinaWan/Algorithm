# Counting Sort 计数排序

## 算法思想

计数排序算法是不基于比较的排序算法，是一种用空间换时间的算法。

主要思想是把待排序数据的数值转化为计数数组的下标，统计每个数值出现的次数，根据累加计数得出原数组中每个元素在排好序的数组中的位置。

计数排序算法需要额外的数组空间，且其大小与数据数值的范围大小k(i.e. max-min)有关。k的大小要在合理的范围内，否则会导致空间复杂度过大。

## 实现方法

1. 遍历待排序数组，找到最大值和最小值，确定计数数组的大小。
2. 遍历待排序数组，统计每个数值出现的次数，记录在计数数组里。
3. 遍历计数数组，计算累加计数。
4. 根据累加计数，反向填充数组。

## 复杂度分析

### 假设

* 数组长度为n，数值范围为k

### 时间复杂度

由实现方法可知，计数排序算法的时间复杂度主要由四部分组成：

1. 遍历待排序数据寻找最大值和最小值的时间，为n
2. 遍历待排序数组统计次数的时间，为n
3. 遍历计数数组计算累加计数的时间，为k
4. 根据累加计数反向填充数组的时间，为n

所以，算法的最终时间复杂度为O(n+k)

**最优时间复杂度**：O(n+k)

**最差时间复杂度**：O(n+k)

**平均时间复杂度**：O(n+k)

### 空间复杂度

需要额外的计数数组，空间复杂度为O(k)

需要额外的临时数组来进行反向填充，空间复杂度为O(n)

所以，算法的最终空间复杂度为O(n+k)

## 稳定性分析

计数排序算法是稳定的排序算法，反向填充保证了算法的稳定性，使得重复元素在排序前后的相对位置可以保持不变。但是也有不稳定的实现方式。

## 扩展/优化