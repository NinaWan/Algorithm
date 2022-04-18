## 排序算法比较表

|                | 算法      |     最优时间复杂度      |     最差时间复杂度      |      平均时间复杂度       | 稳定性 |      空间复杂度       |
|----------------|---------|:----------------:|:----------------:|:------------------:|:---:|:----------------:|
| Bubble Sort    | 冒泡排序    |       O(n)       | O(n<sup>2</sup>) |  O(n<sup>2</sup>)  | 稳定  |       O(1)       |
| Counting Sort  | 计数排序    |      O(n+k)      |      O(n+k)      |       O(n+k)       |     |      O(n+k)      |
| Bucket Sort    | 桶排序     |       O(n)       |     O(nlogn)     | O(n+n(logn-logk))  |     |      O(n+k)      |
| Heap Sort      | 堆排序     |     O(nlogn)     |     O(nlogn)     |      O(nlogn)      | 不稳定 |       O(1)       |
| Insertion Sort | 插入排序    |       O(n)       | O(n<sup>2</sup>) |  O(n<sup>2</sup>)  | 稳定  |       O(1)       |
| Merge Sort     | 归并排序    |     O(nlogn)     |     O(nlogn)     |      O(nlogn)      | 稳定  |       O(n)       |
| Quick Sort     | 快速排序    |     O(nlogn)     | O(n<sup>2</sup>) |      O(nlogn)      | 不稳定 | 最优O(logn)，最差O(n) |
| Selection Sort | 选择排序    | O(n<sup>2</sup>) | O(n<sup>2</sup>) |  O(n<sup>2</sup>)  | 不稳定 |       O(1)       |
| Shell Sort     | 希尔排序    |       O(n)       | O(n<sup>2</sup>) | O(n<sup>1.3</sup>) | 不稳定 |       O(1)       |
| Radix Sort     | 基数排序    |    O(d(r+n))     |    O(d(n+rd))    |     O(d(r+n))      | 稳定  |     O(rd+n)      |
| TimSort        | TimSort |                  |                  |                    |     |                  |

Note:

1. 计数排序的复杂度中，k代表待排序数据的数值范围。
2. 基数排序的复杂度中，r代表关键字的基数，d代表位数，n代表关键字的个数，也就是说基数排序不受待排序数组规模的影响。
3. 桶排序的复杂度中，k代表桶的个数。

稳定性：重复元素在排序前后，相对位置是否改变。对于基本数据类型，排序稳定性没有意义，而对于引用类型，排序稳定性有意义。

## 排序算法分类