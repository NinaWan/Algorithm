# Bubble Sort 冒泡排序

## 算法思想

每次比较相邻两项元素的大小，不符合预想顺序则交换。

## 实现方法

双重for循环

## 复杂度分析

### 假设

* 数组长度为n

### 时间复杂度

外循环遍历数组需要n时间，内循环遍历数组需要n时间

**最优时间复杂度**：数组已有序 O(n)

**最差时间复杂度**：数组逆序 O(n<sup>2</sup>)

**平均时间复杂度**：O(n<sup>2</sup>)

### 空间复杂度

在原数组上操作，空间复杂度为O(1)

## 稳定性分析

冒泡排序是稳定的排序算法，重复元素在排序前后的相对位置保持不变

## 扩展/优化
