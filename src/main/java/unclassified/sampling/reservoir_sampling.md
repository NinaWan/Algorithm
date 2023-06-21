# Reservoir Sampling 蓄水池抽样算法

## 解决的问题

从n个数中随机选出k个数，并保证每个数被选中的概率相同。

[382. Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/)
[398. Random Pick Index](https://leetcode.com/problems/random-pick-index/)
[497. Random Point in Non-overlapping Rectangles](https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/)
[519. Random Flip Matrix](https://leetcode.com/problems/random-flip-matrix/)

## 基本思想

* 算法思想和步骤

  Step 1. 将第1，2，3，...，k个数放入到池中；
  Step 2. 对于第k+1个数，以$\frac {k} {k+1}$的概率被选中，并随机替换池中的一个数；
  Step 3. 对于第k+i个数，以$\frac {k} {k+i}$的概率被选中，并随机替换池中的一个数；
  Step 4. 重复Step 3，直到第n个数；

* 算法正确性证明

  证明：按照上述定义的算法，最终每个数被选中的概率均为$\frac {k} {n}$

    * 对于第k+i个数，根据算法中的定义，它被选中和替换掉池中的一个数的概率为$\frac{k}{k+i}$；
    * 对于前k+i-1个数，每个数保留在池中的概率为：
      P(该数之前在池中的概率)*P(该数不被第k+i个数替换的概率)
      = P(该数之前在池中的概率)*(1-P(该数被第k+i个数替换的概率))
      = $\frac{k}{k+i-1} \times (1-\frac{k}{k+i} \times \frac{1}{k})$
      = $\frac{k}{k+i}$
    * 当k+i=n时，每个数留在池中的概率都为$\frac{k}{n}$.

## 实现

```java
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
```

## 时间复杂度

## 空间复杂度