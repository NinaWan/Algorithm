# Topological Sorting

## 解决的问题

给定一个有向无环图(Directed Acyclic Graph, DAG)，求所有顶点的一个线性排序，满足如果存在边u->v，则最终排序中顶点u一定出现在顶点v之前。

对于非DAG，拓扑排序是不存在的。

对于同一个有向无环图，可能有多个拓扑排序。

## 基本思想

1. 将当前图中入度为0的顶点加入到结果集中；
2. 对于当前图中每一个入度为0的顶点，将顶点本身和连接的所有边从图中移除；
3. 重复步骤1和2，直到图中无剩余顶点。

Tips: 像剥洋葱一样，一层一层剥开。

## 实现

### BFS

### DFS

## 时间复杂度

DFS - O(n+m)

n - number of nodes/vertices

m - number of edges

## 空间复杂度

DFS - O(n)

# Refs

1. [Topological Sorting - GeeksForGeeks](https://www.geeksforgeeks.org/topological-sorting/)