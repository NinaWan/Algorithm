# Quick Power 快速幂

## 解决的问题

快速求解a的n次方，其中a和n都比较大。

## 基本思想

已知，a<sup>x+y</sup> = a<sup>x</sup> $\times$ a<sup>y</sup>，据此可将原问题分解成子问题：

1. n is odd, a<sup>n</sup> = a $\times$ a<sup>n/2</sup> $\times$ a<sup>n/2</sup>；
2. n is even, a<sup>n</sup> = a<sup>n/2</sup> $\times$ a<sup>n/2</sup>。

## 实现

## 时间复杂度

$O(\log n)$

## 空间复杂度

# Refs

1. [快速幂 - OI Wiki](https://oi-wiki.org/math/binary-exponentiation/)