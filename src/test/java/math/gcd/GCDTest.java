package math.gcd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDTest {
    private GCD tested;

    @BeforeEach
    void setup() {
        tested = new GCD();
    }

    @Test
    void gcd_recursive() {
        assertEquals(2, GCD.gcd_recursive(6, 8));
        assertEquals(3, GCD.gcd_recursive(6, 9));
        assertEquals(1, GCD.gcd_recursive(6, 7));
    }

    @Test
    void gcd_iterative() {
        assertEquals(2, tested.gcd_iterative(6, 8));
        assertEquals(3, tested.gcd_iterative(6, 9));
        assertEquals(1, tested.gcd_iterative(6, 7));
    }
}