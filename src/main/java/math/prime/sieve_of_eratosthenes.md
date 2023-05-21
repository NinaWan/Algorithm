# Sieve of Eratosthenes

Eratosthenes筛法

## 解决的问题

给定n，求解1~n范围内的质数(个数)。

## 基本思想

对从2开始的每个素数，依次标记n范围内该素数的倍数为非质数。

## 实现

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }

        return ans;
    }
}
```

## 时间复杂度

## 空间复杂度