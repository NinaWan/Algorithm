package math.lcm;

import java.util.Set;

import static math.gcd.GCD.gcd;

public class LCM {
    public int lcm_1(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int lcm_2(int a, int b) {
        for (int i = Math.max(a, b); i < a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return a * b;
    }

    public int lcm_3(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max; i < a * b; i += max) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return a * b;
    }
}
