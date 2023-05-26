# Dijkstra 迪杰斯特拉算法

## 解决的问题

G: 带权值的无向图

s: 起始顶点

S: 已经求出到s的最短路径的顶点合集

U: 还未求出到s的最短路径的顶点合集

dists[i] - the shortest distance from s to i

edges[i] - (u, v, w) means there is an edge between u and v whose weight is w

问题：给定G、s和edges，求出图中每个顶点到s的最短路径？

## 基本思想

Step 1.

* 将s加入到S中，将除s之外的其他顶点加入到U中；
* 初始化dists：dists[0...n)=∞; dists[s]=0;
* 遍历s的邻接顶点，更新对应的dists。

Step 2. 从U中选出距离s最短的顶点k，加入到S中，并从U中移除k;

Step 3. 遍历k的邻接顶点，更新对应的dists。

Step 4. 重复Step 2和Step 3，直到U为空。

## 实现

## 时间复杂度

## 空间复杂度