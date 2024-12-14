# Sieve of Eratosthenes

Eratosthenes筛法

## 解决的问题

给定n，求解1~n范围内的[质数](https://baike.baidu.com/item/%E8%B4%A8%E6%95%B0/263515 "质数（英文名：Prime Number）又称素数，是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。")(个数)。

[LeetCode 204. Count Primes](https://leetcode.com/problems/count-primes/)

## 基本思想

对从2开始的每个素数，依次标记n范围内该素数的倍数为非质数。

## 实现

```java
private boolean[] sieve(int n) {
    boolean[] isPrime = new boolean[n + 1];

    Arrays.fill(isPrime, true);

    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return isPrime;
}
```

## 复杂度

### 时间复杂度

### 空间复杂度