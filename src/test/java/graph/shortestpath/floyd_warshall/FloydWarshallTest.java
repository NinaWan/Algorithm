package graph.shortestpath.floyd_warshall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FloydWarshallTest {
    private FloydWarshall tested;
    private int[][] edges;
    private int[][] expected;
    private int n;
    private int inf;

    @BeforeEach
    void setup() {
        n = 5;
        inf = Integer.MAX_VALUE;
        tested = new FloydWarshall();
        edges = new int[][]{{1, 0, 17}, {1, 0, 1}, {2, 1, 24}, {3, 2, 12}, {1, 0, 7}, {3, 2, 4}, {2, 1, 15}, {0, 4, 14}};
        expected = new int[][]{{0, inf, inf, inf, 14}, {1, 0, inf, inf, 15}, {16, 15, 0, inf, 30}, {20, 19, 4, 0, 34}, {inf, inf, inf, inf, 0}};
    }

    @Test
    void shortestPaths() {
        assertArrayEquals(expected, tested.shortestPaths(n, edges));
    }
}