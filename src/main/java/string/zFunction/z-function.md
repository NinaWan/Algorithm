# Z-Function

## 解决的问题

给定字符串s，求出s的每个后缀与s的最长公共前缀的长度。

定义z[i]表示s与s[i:]的最长公共前缀的长度，即满足s[0, len) = s[i, i+len)的最大的len值。特别的，z[0] = 0。

## 基本思想

最容易想到的是暴力匹配，即将s的每个后缀与s进行一遍逐字符匹配。显而易见，这种方法的时间复杂度为O(n^2)。

Z-Function算法提供了一种更为高效的求解方法，其基本思路是对于当前的后缀s[i:]，利用在此之前已经求解出的最长公共前缀的长度，减少不必要的字符比较。

`Details`

根据z的定义可知，s[i, i+z[i]-1]与s[0, z[i]-1]匹配，因此将s[i, i+z[i]-1]称为s[i:]的匹配段。

从1到n-1依次计算z[i]，同时记录已经计算出的z[j] j$\in$[0, i-1]中右端点最靠右的匹配段s[l, r]，用来辅助z[i]的计算。 其中，l = j, r = j+z[j]-1，可知l一点小于i，因此只需要根据i与r的大小关系进行分类讨论：

1. 如果i>r，之前计算出的值没有参考价值，直接采用暴力匹配来计算z[i]；
2. 如果i<=r，则有l<i<=r。已知s[l, r] = s[0, r-l]，可得s[i, r] = s[i-l, r-l]，因此可以利用z[i-l]的值来跳过不必要的字符比较。
    * 如果z[i-l] < len(s[i-l, r-l]) = r-i+1，则有s[i, i+z[i-l]-1] = s[i-l, i-l+z[i-l]-1] = s[0, z[i-l]-1]，即s[i, i+z[i-l]-1]内的字符是完全匹配的，不需要再重新检查。 又知s[i+z[i-l]] = s[i-l+z[i-l]] $\not=$ s[z[i-l]]，所以可知s[i:]与s的最长公共前缀为s[i, i+z[i-l]-1]，长度为z[i-l]，即z[i] = z[i-l]。
    * 如果z[i-l] >= len(s[i-l, r-l]) = r-i+1，则有s[i, r] = s[i-l, r-l] = s[0, r-i]，即s[i, r]内的字符是完全匹配的，不需要再重新检查。又知s[r-l+1] = s[r-i+1]，但是s[r+1]是否与s[r-l+1]匹配并不明确，所以只能确定z[i]>=r-i+1，令z[i]=r-i+1，并从s[r+1]和s[r-i+1]开始进行暴力匹配，从而得到z[i]的最终结果。
3. 计算出z[i]的值后，如果右端点i+z[i]-1>r，则需要用当前的匹配段s[i, i+z[i]-1]替换掉之前的匹配段s[l, r]。

## 实现

`Trivial`

```java
public int[] z_trivial(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 0; i < n; i++) {
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
            z[i]++;
        }
    }
    return z;
}
```

`Linear`

```java
public int[] z(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; i++) {
        if (i <= r) {
            z[i] = Math.min(r - i + 1, z[i - l]);
        }

        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
            z[i]++;
        }

        if (i + z[i] - 1 > r) {
            l = i;
            r = i + z[i] - 1;
        }
    }
    return z;
}
```

## 复杂度

### 时间复杂度

O(n)

### 空间复杂度

## 应用

## Related Programming Problems

* [LeetCode 2223. Sum of Scores of Built Strings](https://leetcode.com/problems/sum-of-scores-of-built-strings/description/)
* [LeetCode 3303. Find the Occurrence of First Almost Equal Substring](https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/)

## Refs

1. [Z 函数（扩展 KMP）](https://oi-wiki.org/string/z-func/#__tabbed_1_1)
2. [Z-function and its calculation](https://cp-algorithms.com/string/z-function.html)