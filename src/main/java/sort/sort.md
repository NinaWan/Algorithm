|                | 算法      |      最优时间复杂度       |      最差时间复杂度       |       平均时间复杂度        |  稳定性  |      空间复杂度       |
|----------------|---------|:------------------:|:------------------:|:--------------------:|:-----:|:----------------:|
| Selection Sort | 选择排序    |  O(n<sup>2</sup>)  |  O(n<sup>2</sup>)  |   O(n<sup>2</sup>)   |  不稳定  |       O(1)       |
| Bubble Sort    | 冒泡排序    |        O(n)        |  O(n<sup>2</sup>)  |   O(n<sup>2</sup>)   |  稳定   |       O(1)       |
| Insertion Sort | 插入排序    |        O(n)        |  O(n<sup>2</sup>)  |   O(n<sup>2</sup>)   |  稳定   |       O(1)       |
| Shell Sort     | 希尔排序    |        O(n)        |  O(n<sup>2</sup>)  |  O(n<sup>1.3</sup>)  |  不稳定  |       O(1)       |
| Merge Sort     | 归并排序    |      O(nlogn)      |      O(nlogn)      |       O(nlogn)       |  稳定   |       O(n)       |
| Quick Sort     | 快速排序    |      O(nlogn)      |  O(n<sup>2</sup>)  |       O(nlogn)       |  不稳定  | 最优O(logn)，最差O(n) |
| Heap Sort      | 堆排序     |      O(nlogn)      |      O(nlogn)      |       O(nlogn)       |  不稳定  |       O(1)       |
| Radix Sort     | 基数排序    |     O(d(r+n))      |     O(d(n+rd))     |      O(d(r+n))       |  稳定   |     O(rd+n)      |
| Bucket Sort    | 桶排序     |                    |                    |        O(n+k)        |       |      O(n+k)      |
| TimSort        | TimSort |                    |                    |                      |       |                  |

Note: 基数排序的时间复杂度中，r代表关键字的基数，d代表位数，n代表关键字的个数，也就是说基数排序不受待排序数组规模的影响。

稳定性：重复元素在排序前后，相对位置是否改变。