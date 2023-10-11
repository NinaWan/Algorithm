package graph.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {
    private TopologicalSort tested;
    private List<Integer> expected_bfs;
    private List<Integer> expected_dfs;
    private Map<Integer, List<Integer>> graph;
    private int n;

    @BeforeEach
    void setUp() {
        n = 6;
        tested = new TopologicalSort();
        graph = new HashMap<Integer, List<Integer>>() {{
            put(2, Arrays.asList(3));
            put(3, Arrays.asList(1));
            put(4, Arrays.asList(0, 1));
            put(5, Arrays.asList(0, 2));
        }};
        expected_bfs = Arrays.asList(4, 5, 0, 2, 3, 1);
        expected_dfs = Arrays.asList(5, 4, 2, 3, 1, 0);
    }

    @Test
    void bfs() {
        List<Integer> actual = tested.bfs(n, graph);
        for (int i = 0; i < n; i++) {
            assertEquals(expected_bfs.get(i), actual.get(i));
        }
    }

    @Test
    void dfs() {
        List<Integer> actual = tested.dfs(n, graph);
        for (int i = 0; i < n; i++) {
            assertEquals(expected_dfs.get(i), actual.get(i));
        }
    }
}