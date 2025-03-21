# Quick Sort 快排序

## 算法思想

1. 从数组中挑出一个元素，作为基准(pivot)
2. 重新排列数组，比基准值小的放在基准的左边，比基准值大的放在右边
3. 再分别对左右区间重复第二步，直到各区间只有一个元素

## 实现方法

递归

## 复杂度分析

### 假设

* 数组长度为n

### 时间复杂度

```
public void sort(int[] nums, int start, int end) {
   if (start >= end) {
       return;
   }

   int pivotIdx = partition(nums, start, end); // 时间复杂度为O(n)
   sort(nums, start, pivotIdx - 1); // 时间复杂度为T()
   sort(nums, pivotIdx + 1, end);
}
```

在快排算法中，数组会被分成两个子序列，长度分别为pivotIdx和n-pivotIdx-1，对两个子序列调用递归排序的时间复杂度为T(pivotIdx)和T(n-pivotIdx-1)；另外，partition部分的时间复杂度为O(n)
。所以快排的总时间复杂度为三者相加，即T(n) = T(pivotIdx)+T(n-pivotIdx-1)+O(n)。特别地，T(0) = T(1) = 0。

**最优时间复杂度**：$O(n\log n)$

最优的情况是每次数组分割得到的两个子序列长度均等。这种情况下，算法的时间复杂度T(n) = T($\frac{n}{2}$)+T($\frac{n}{2}$)+O(n)

*时间复杂度推导*：

$$\begin{aligned} 
T(n) &= 2T(\frac{n}{2})+n \\ 
     &= 2(2T(\frac{n}{2})+\frac{n}{2})+n \\ 
     &= 4T(\frac{n}{4})+2n \\ 
     &= 4(2T(\frac{n}{8})+\frac{n}{4})+2n \\ 
     &= 8T(\frac{n}{8})+3n \\ &= ... ... \\ 
     &= 2^kT(\frac{n}{2^k})+kn \\ &= nT(1)+n\log n \\
     &= O(n\log n) \\ 
\end{aligned}$$

**最差时间复杂度**：$O(n^2)$

最差的情况是每次数组分割得到的两个子序列长度为n-1和0，即每次都选择了当前最大或者最小的元素作为基准。这种情况下，算法的时间复杂度T(n) = T(n-1)+T(0)+O(n) = T(n-1)+O(n)

*时间复杂度推导*：

$$\begin{aligned} 
T(n) &= T(n-1)+n \\ 
     &= T(n-2)+(n-1)+n \\ 
     &= T(n-3)+(n-2)+(n-1)+n \\ 
     &= ... ... \\ 
     &= T(0)+1+2+...+(n-1)+n \\ &= T(0)+\frac{n*(n+1)}{2} \\ 
     &= O(n^2) \\ 
\end{aligned}$$

**平均时间复杂度**：$O(n\log n)$

### 空间复杂度

partition函数是在原有数组上进行操作，空间复杂度为O(1)，所以快排的空间复杂度主要来自于递归所造成的的栈空间的使用，所以需要知道递归栈的深度。

**最优空间复杂度**：$O(\log n)$

最优的情况下，每次数组都被分割为两个均等的子序列，设栈的深度为k，则有$n(\frac{1}{2})^k$=1，可得$k=\log n$，即空间复杂度为O($\log n$)。

**最差空间复杂度**：$O(n)$

最差的情况下，每次数组都被分割成长度为n-1和0的两个子序列，所以递归的深度为n，每次递归所需要的空间是固定的，所以总的空间复杂度为O(n)。

**平均空间复杂度**：$O(\log n)$

## 稳定性分析

快排是不稳定的排序算法，重复元素在排序前后的相对位置可能会发生改变，e.g. [4, 3, 5, 3]，基准选取策略为选取第一个元素。

## 扩展/优化

快排算法的优化主要体现在pivot的选取上，常见的选取方法有三种：固定选取，随机选取，三数取中。

**固定选取**

选择待排序数组中固定位置的元素作为基准，一般选择第一个元素或者最后一个元素。

**随机选取**

随机选取待排序数组中的一个元素作为基准。

**三数取中**

取待排序数组的第一个元素、中间元素和最后一个元素，取三个数排序后中间的那个元素作为基准。这种方法可以有效避免最差情况的发生(i.e. 待排序数组已有序，包括正序和逆序，基准为最大值或者最小值，导致时间复杂度和空间复杂度最大)。

## Refs

1. [【算法】快速排序](https://www.cnblogs.com/HDK2016/p/6876313.html#a31)
