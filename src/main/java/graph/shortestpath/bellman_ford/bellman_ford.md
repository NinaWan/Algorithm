# Bellman-Ford

## 概述

> The simplest implementation of Ford’s generic shortest-path algorithm was first sketched by Alfonso Shimbel in 1954, described in more detail by Edward Moore in 1957, and independently rediscovered by Max Woodbury and George Dantzig in 1957, by Richard Bellman in 1958, and by George Minty in 1958. (Neither Woodbury and Dantzig nor Minty published their algorithms.)

> In full compliance with Stigler’s Law, the algorithm is almost universally known as Bellman-Ford, because Bellman explicitly used Ford’s 1956 formulation of relaxing edges, although some authors refer to "Bellman-Kalaba" and a few early sources refer to "Bellman-Shimbel".

Bellman-Ford算法是以Richard Bellman和Lester Ford命名的。

## 解决的问题

单源最短路径问题，求解给定起点到图中每个顶点的最短路径。

与Dijkstra算法相比，Bellman-Ford算法可以用于求解带负权值边的最短路径问题，并且可以检测出图中是否存在负权环。实现简单，但时间复杂度高。

## 基本思想

`松弛操作 Relaxation`

松弛法(Relaxation Method)是数学学科数值分析领域中的术语，是一种加速迭代方法。在最短路径问题中，松弛操作可以理解为不断用更加准确的值替代估计的最短路径值，直至得到最优解。

Bellman-Ford算法是以松弛操作为基础，基本思想是对图进行V-1次松弛操作，得到所有可能的最短路径。其中，V为图中顶点个数。

Dijkstra算法也是以松弛操作为基础，但是与Bellman-Ford算法不同的是Dijkstra算法采用的是贪心策略(Greedy)，每次选取未被处理的顶点中边权值最小的那个，对其出边进行松弛操作；而Bellman-Ford算法采用的是暴力策略(Brute Force)，对所有边进行V-1次松弛操作。

## 实现

1. 初始化
2. 进行V-1次松弛操作
3. 检测图中是否有负权环

## 复杂度

### 时间复杂度

O(VE)

V - 顶点个数

E - 边个数

### 空间复杂度

## 优化

1. 提前跳出循环：当某次松弛操作不再产生变化时，可以提前跳出循环。
2. 队列优化

## Refs

1. [Why is the Bellman-Ford's shortest path algorithm sometimes called Bellman-Kalaba?](https://or.stackexchange.com/questions/6476/why-is-the-bellman-fords-shortest-path-algorithm-sometimes-called-bellman-kalab)
2. [Algorithms by Jeff Erickson](https://jeffe.cs.illinois.edu/teaching/algorithms/book/Algorithms-JeffE.pdf)
3. [The Bellman-Ford Algorithm - TUM](https://algorithms.discrete.ma.tum.de/graph-algorithms/spp-bellman-ford/index_en.html)