package graph.shortestpath.floyd_warshall;

import java.util.Arrays;

public class FloydWarshall {
    private int INF = Integer.MAX_VALUE;

    public int[][] shortestPaths(int n, int[][] edges) {
        int[][] dists = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dists[i], INF);
        }

        for (int i = 0; i < n; i++) {
            dists[i][i] = 0;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], d = edge[2];
            dists[a][b] = Math.min(dists[a][b], d);
            // dists[b][a] = Math.min(dists[b][a], d); // for undirected graph
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dists[i][k] == INF || dists[k][j] == INF) {
                        continue;
                    }

                    dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
                }
            }
        }

        return dists;
    }
}
