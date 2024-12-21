package math.calculation.quickPower;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickPowerTest {
    private QuickPower tested;

    @BeforeEach
    public void setup() {
        tested = new QuickPower();
    }

    @Test
    void iteration() {
        assertEquals(13, tested.iteration(3, 18132, 17));
        assertEquals(2, tested.iteration(17, 1765, 3));
        assertEquals(13195, tested.iteration(2374859, 3029382, 36123));
    }

    @Test
    void recursion() {
        assertEquals(13, tested.recursion(3, 18132, 17));
        assertEquals(2, tested.recursion(17, 1765, 3));
        assertEquals(13195, tested.recursion(2374859, 3029382, 36123));
    }
}