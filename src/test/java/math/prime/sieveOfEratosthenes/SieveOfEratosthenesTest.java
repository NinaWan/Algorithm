package math.prime.sieveOfEratosthenes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SieveOfEratosthenesTest {
    private SieveOfEratosthenes tested;

    @BeforeEach
    void setup() {
        tested = new SieveOfEratosthenes();
    }

    @Test
    void countPrimes() {
        assertEquals(3, tested.countPrimes(5));
        assertEquals(4, tested.countPrimes(10));
    }

    @Test
    void getPrimes() {
        assertEquals(Arrays.asList(2, 3, 5), tested.getPrimes(5));
        assertEquals(Arrays.asList(2, 3, 5, 7), tested.getPrimes(10));
    }
}