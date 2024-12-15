package math.lcm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCMTest {
    private LCM tested;

    @BeforeEach
    void setup() {
        tested = new LCM();
    }

    @Test
    void lcm_1() {
        assertEquals(12, tested.lcm_1(4, 6));
    }

    @Test
    void lcm_2() {
        assertEquals(12, tested.lcm_2(4, 6));
    }

    @Test
    void lcm_3() {
        assertEquals(12, tested.lcm_3(4, 6));
    }
}