package math.calculation.combination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationTest {
    private Combination tested;

    @BeforeEach
    void setup() {
        tested = new Combination();
    }

    @Test
    void combination_formula_1() {
        assertEquals(99884400, tested.combination_formula_1(50, 7));
    }

    @Test
    void combination_formula_2() {
        assertEquals(99884400, tested.combination_formula_2(50, 7));
    }

    @Test
    void combination_recursive() {
        assertEquals(99884400, tested.combination_recursive(50, 7, new int[51][8], Integer.MAX_VALUE));
        assertEquals(30, tested.combination_recursive(50, 7, new int[51][8], 1002));
    }

    @Test
    void combination_pascal_triangle() {
        assertEquals(99884400, tested.combination_pascal_triangle(50, 7, Long.MAX_VALUE));
        assertEquals(30, tested.combination_pascal_triangle(50, 7, 1002));
    }

    @Test
    void combination_inverse() {
        assertEquals(99884400, tested.combination_inverse(50, 7));
    }
}