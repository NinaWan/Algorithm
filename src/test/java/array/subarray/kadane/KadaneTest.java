package array.subarray.kadane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KadaneTest {
    private Kadane tested;
    private int[] nums;

    @BeforeEach
    void setup() {
        nums = new int[]{64, -25, 42, 10, -70, 22, 35, -96, 61, 49};
        tested = new Kadane();
    }

    @Test
    void maxSubArray() {
        assertEquals(110, tested.maxSubArray(nums));
    }
}