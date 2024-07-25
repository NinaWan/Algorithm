package string.match.kmp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPTest {
    private KMP tested;
    private String text;
    private String pattern1;
    private String pattern2;

    @BeforeEach
    void setup() {
        text = "BBC ABCDAB ABCDABCDABDE";
        pattern1 = "ABCDABD";
        pattern2 = "ABCDABF";
        tested = new KMP();
    }

    @Test
    void match() {
        assertEquals(15, tested.match(text, pattern1));
        assertEquals(-1, tested.match(text, pattern2));
    }
}