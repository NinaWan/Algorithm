# Least Common Multiple (LCM) 最小公倍数

## 解决的问题

求解两个数的最小公倍数。

## Solutions

### Solution 1 `利用最大公约数`

#### 基本思想

两数的乘积除以两者的最大公约数。

### Solution 2 `加穷举`

#### 基本思想

在[max(a,b), a*b]范围内依次check每个数，返回第一个能被a和b整除的数。

### Solution 3 `乘穷举`

#### 基本思想

* 如果b>a，依次check 1 * b、2 * b ... a * b，返回第一个能被a和b整除的数；
* 如果b<a，依次check 1 * a、2 * a ... b * a，返回第一个能被a和b整除的数；
* 如果a==b，返回a。

### Solution 4 `质因数`

#### 基本思想

分别列出a和b的质因数，求并集的乘积即可。