package graph.shortestpath.bellman_ford;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BellmanFordTest {
    private BellmanFord tested;
    private int[][] edges_standard;
    private int[][] edges_positive_circle;
    private int[][] edges_negative_circle;
    private static final int infinite = Integer.MAX_VALUE;

    @BeforeEach
    void setup() {
        tested = new BellmanFord();
        edges_standard = new int[][]{{1, 0, 33}, {0, 2, 1}, {3, 2, -2}, {3, 0, -20}, {4, 3, 50}, {4, 0, 10}, {1, 3, 20}, {5, 1, 20}, {5, 4, 10}};
        edges_positive_circle = new int[][]{{0, 1, 10}, {2, 1, 5}, {4, 2, 5}, {1, 3, 10}, {3, 4, 7}, {4, 5, 15}};
        edges_negative_circle = new int[][]{{0, 1, 10}, {1, 3, 1}, {3, 4, 3}, {4, 2, -10}, {2, 1, 4}, {4, 5, 22}};
    }

    @Test
    void shortestPath() {
        assertArrayEquals(new int[]{0, infinite, 1, infinite, infinite, infinite}, tested.shortestPath(0, 6, edges_standard));
        assertArrayEquals(new int[]{0, 0, 1, 20, infinite, infinite}, tested.shortestPath(1, 6, edges_standard));

        assertArrayEquals(new int[]{0, 10, 32, 20, 27, 42}, tested.shortestPath(0, 6, edges_positive_circle));

        assertThrows(RuntimeException.class, () -> tested.shortestPath(0, 6, edges_negative_circle), "Negative circle is detected!");
    }
}