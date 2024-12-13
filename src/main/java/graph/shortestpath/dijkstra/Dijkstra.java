package graph.shortestpath.dijkstra;

import java.util.*;

public class Dijkstra {
    public int[] shortestPathAll_Naive(int start, int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = toGraph(edges);
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;
        Set<Integer> visited = new HashSet();

        while (true) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && (u == -1 || dists[i] < dists[u])) {
                    u = i;
                }
            }

            if (visited.size() == n) {
                return dists;
            }

            visited.add(u);

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(u, new HashMap<>()).entrySet()) {
                int v = entry.getKey(), w = entry.getValue();
                dists[v] = Math.min(dists[v], dists[u] + w);
            }
        }
    }

    /**
     * @param start
     * @param n
     * @param edges
     * @return Shortest distances from start to other nodes in the graph.
     */
    public int[] shortestPathAll_Queue(int start, int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = toGraph(edges);
        // <node, dist> - sort by distance ascending
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{start, 0});
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], dist = cur[1];

            if (dists[node] < dist) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(node, new HashMap<>()).entrySet()) {
                int next = entry.getKey(), weight = entry.getValue();
                if (dist + weight < dists[next]) {
                    dists[next] = dist + weight;
                    queue.offer(new int[]{next, dist + weight});
                }
            }
        }

        return dists;
    }

    /**
     * @param start
     * @param end
     * @param n
     * @param edges
     * @return Shortest distance from start to end.
     */
    public int shortestPath_Queue(int start, int end, int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = toGraph(edges);
        // <node, dist> - sort by distance ascending
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{start, 0});
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], dist = cur[1];
            if (node == end) {
                return dist;
            }

            if (dists[node] < dist) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(node, new HashMap<>()).entrySet()) {
                int next = entry.getKey(), weight = entry.getValue();
                if (dist + weight < dists[next]) {
                    dists[next] = dist + weight;
                    queue.offer(new int[]{next, dist + weight});
                }
            }
        }

        return -1;
    }

    private Map<Integer, Map<Integer, Integer>> toGraph(int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new HashMap()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], x -> new HashMap()).put(edge[0], edge[2]);
        }
        return graph;
    }
}
