package graph.sorting;

import java.util.*;

public class TopologicalSort {
    public List<Integer> bfs(int n, Map<Integer, List<Integer>> graph) {
        int[] indegree = new int[n];
        for (List<Integer> nodes : graph.values()) {
            for (int v : nodes) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return res;
    }

    public List<Integer> dfs(int n, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) { // for each node
            if (!visited[i]) { // not visited
                topologicalSort(i, visited, stack, graph);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    private void topologicalSort(int node, boolean[] visited, Deque<Integer> stack, Map<Integer, List<Integer>> graph) {
        visited[node] = true;
        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited[next]) {
                topologicalSort(next, visited, stack, graph);
            }
        }
        stack.push(node);
    }
}
