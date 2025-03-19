# Digit DP

## 解决的问题

统计整数区间[a, b]内，满足与数位相关的特定属性的整数x的个数。

## 算法思想

假定G(x)为整数区间[1, x]内，满足条件的整数的个数，则最终答案为G(b)-G(a-1)。

G(x)的求解过程可以通过数位DP实现，过程如下：

1. 将x用数位表示，位数为n，从左至右下标依次为n, n-1, ..., 1；
2. 依次构建小于等于x的整数：
    1. 从位数为1的整数开始构建，直到位数为n的整数，同时判断整数是否满足要求的属性；
    2. 记dp(i)为位数至多为i的符合要求的整数的个数，则在之前的状态dp(i-1)基础上，通过对最高位(i.e. 第i位)取不同的值(i.e. 0-9，且不超过x的第i位数值)来得到dp(i)的结果，避免重复计算。

特别地，当最高位的取值等于x的第i位数值时，为了使最终构建的整数不超过x，则要求次高位的取值也不超过x的第i-1位数值。

所以，在位数的基础上，需要加多一个参数tight来区分不同的状态。tight用来表示当前最高位的取值是否受到x对应数位数值的限制。

因此，可以得到如下状态转换：

* dp[i][0] = for d in [0, 9] {if isSatisfied: +dp[i-1][0]}
* dp[i][1] = for d in [0, max-1] {if isSatisfied: +dp[i-1][0]} + d=max {if isSatisfied: +dp[i-1][1]}

tight：0，表示当前最高位的取值不受限制；1，表示当前最高位的取值受限制。

此外，根据题目的要求，可能需要添加更多的参数来区分不同的状态，例如，前一个数位的取值等。

## 算法实现(伪代码)

### Recursion

```
public int countInRange(int a, int b){
    return countInRange(b)-countInRange(a-1);
}

public int countInRange(int num){
    int[][] dp = new int[num.length][2];
    fill(dp, -1)
    return countInRange(num, 0, 1, dp);
}

// i - index of digit, from left to right is 0...n-1
public int countInRange(int num, int i, int tight, int[][] dp){
    if(i==num.length){
        return isSatisfied ? 1:0;
    }
    
    if(dp[i][tight]!=-1 && tight==0){
        return dp[i][tight];
    }
    
    int res = 0, max = tight==1 ? num[i]:9;
    for(int d=0; d<=max; d++){
        res += countInRange(num, i+1, tight==1 && d==max, dp);
    }
    
    if(tight==0){
        dp[i][tight] = res;
    }
    
    return res;
}
```

### Iteration

```
public int countInRange(int a, int b){
    return countInRange(b)-countInRange(a-1);
}

public int countInRange(int num){
    int n = num.length;
    int[][] dp = new int[n][2];
    
    for(int d=0; d<=9; d++){
        dp[0][0] += isSatisfied ? 1:0;
        if(d<=num[0]){
            dp[0][1] += isSatisfied ? 1:0;
        }
    }
    
    // i - index of digit, from left to right is n-1...0
    for(int i=1; i<n; i++){
        for(int d=0; d<=9; d++){
            dp[i][0] += isSatisfied ? dp[i-1][0]:0;
        }
        
        for(int d=0; d<=num[i]; d++){
            if(d<num[i]){
                dp[i][1] += isSatisfied ? dp[i-1][0]:0;
            }else{
                dp[i][1] += isSatisfied ? dp[i-1][1]:0;
            }
        }
    }
    
    return dp[n-1][1];
}
```

## Related Programming Problems

* [LeetCode 2376. Count Special Integers](https://leetcode.com/problems/count-special-integers/)
* [LeetCode 2801. Count Stepping Numbers in Range](https://leetcode.com/problems/count-stepping-numbers-in-range/)
* [LeetCode 2827. Number of Beautiful Integers in the Range](https://leetcode.com/problems/number-of-beautiful-integers-in-the-range/)
* [LeetCode 3490. Count Beautiful Numbers](https://leetcode.com/problems/count-beautiful-numbers/)

## Refs

1. [Digit DP | Introduction - GeeksForGeeks](https://www.geeksforgeeks.org/digit-dp-introduction/)