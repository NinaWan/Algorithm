# Combination 组合数

## 解决的问题

从n个不同元素中任意选取m个作为一个组，求这样的组合的个数，记作$C_n^m$。

`组合数公式`

$C_n^m = \frac{A_n^m}{m!} = \frac{n!}{m!(n-m)!}$

## Solutions

### Solution 1: `组合数公式`

#### 基本思想

利用组合数的求解公式。

#### 实现

**实现一：** 先乘后除，可能出现整数乘积的溢出问题，适应于n不是很大的情况。

```java
// C(n, m) = n!/(m!*(n-m)!)
public long combination(long n, long m) {
    long res = 1;
    for (long i = n - m + 1; i <= n; i++) {
        res *= i;
    }
    for (long i = 1; i <= m; i++) {
        res /= i;
    }
    return res;
}
```

**实现二：** 边乘边除，当n为int时可以确保不会发生整数乘积的溢出问题。

```java
// C(n, m) = n!/(m!*(n-m)!)
public long combination(int n, int m) {
    long res = 1, k = 1;
    while (k <= m) {
        res = (n - k + 1) * res / k;
        k++;
    }
    return res;
}
```

### Solution 2: `自顶向下动态规划`

#### 基本思想

对于每一个元素可以分为选取或者不选取两种情况，最终的结果为这两种情况的组合数的和。

#### 实现

```java
public int combination(int n, int m, int[][] memo, int mod) {
    if (m == 0) {
        return 1;
    }

    if (n == 0) {
        return 0;
    }

    if (memo[n][m] != 0) {
        return memo[n][m];
    }

    return memo[n][m] = (combination_recursive(n - 1, m, memo, mod) + combination_recursive(n - 1, m - 1, memo, mod)) % mod;
}
```

### Solution 3： `杨辉三角/Pascal‘s Triangle`

#### 基本思想

利用杨辉三角第n行第m列(i.e. 0-based)的数值等于$C_n^m$的性质，通过构建大小为$n \times n$的杨辉三角二维数组，可快速获取任意$C_n^m (m \in [0...n])$的值。

#### 实现

```java
public long combination(int n, int m, long mod) {
    long[][] triangle = new long[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
        triangle[i][0] = 1;
        for (int j = 1; j <= i; j++) {
            triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]) % mod;
        }
    }
    return triangle[n][m];
}
```

### Solution 4: `乘法逆元`

#### 基本思想

利用乘法逆元将除法转化为乘法，避免大数运算时的溢出问题。

#### 实现

```java
public long combination_inverse(int n, int m) {
    int mod = (int) 1e9 + 7;
    // pre-calculations
    long[] fact = new long[n + 1]; // fact[i] - i!, factorial of i
    long[] inv = new long[n + 1]; // inv[i] - multiplicative inverse modulo for factorial of i
    fact[0] = inv[0] = 1;
    for (int i = 1; i <= n; i++) {
        fact[i] = fact[i - 1] * i % mod;
        inv[i] = quickPowMod(fact[i], mod - 2, mod); // inv[i] = (1/i!)%mod
    }

    // C(n, m) = n!/(m!*(n-m)!) = n! * 1/m! * 1/(n-m)!
    return fact[n] * inv[m] % mod * inv[n - m] % mod;
}

private long quickPowMod(long base, int exponent, int mod) {
    long res = 1;

    for (; exponent > 0; exponent >>= 1) {
        if ((exponent & 1) == 1) {
            res = res * base % mod;
        }
        base = base * base % mod;
    }

    return res;
}
```