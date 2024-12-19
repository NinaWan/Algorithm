package graph.shortestpath.bellman_ford;

import java.util.Arrays;

public class BellmanFord {
    public int[] shortestPath(int start, int n, int[][] edges) {
        // initialization
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        // relaxation
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                relax(edge, dists);
            }
        }

        // check negative weight circle
        for (int[] edge : edges) {
            if (relax(edge, dists)) {
                throw new RuntimeException("Negative weight circle is detected!");
            }
        }

        return dists;
    }

    private boolean relax(int[] edge, int[] dists) {
        int u = edge[0], v = edge[1], weight = edge[2];
        if (dists[u] != Integer.MAX_VALUE && dists[u] + weight < dists[v]) {
            dists[v] = dists[u] + weight;
            return true;
        }
        return false;
    }
}