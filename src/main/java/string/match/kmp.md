# KMP

Knuth-Morris-Pratt算法

## 解决的问题

字符串匹配

给定两个字符串，s和t，判断s中是否包含t

## 基本思想

如果t的组成类似于ABC...ABC，即前缀与后缀匹配，我们可以利用该性质，在s与t的匹配过程中可以跳过那些已经比较过的位置，从而加快匹配的过程。

如果到t[i]时发现不配，则：

移动的位数 = 已经匹配的位数(i) - t[0...i)的前后缀匹配长度；

## 实现

```
    private int[] generateKMPTable(String s) {
        int[] res = new int[s.length()];

        for (int i = 1, j = 0; i < res.length; ) {
            if (s.charAt(i) == s.charAt(j)) {
                res[i++] = ++j;
            } else if (j > 0) {
                j = res[j - 1];
            } else {
                j = 0;
                i++;
            }
        }

        return res;
    }
```

## 时间复杂度

## 空间复杂度

## Refs

1. [字符串匹配的KMP算法 - 阮一峰](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)