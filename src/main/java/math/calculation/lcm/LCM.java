package math.calculation.lcm;

import static math.calculation.gcd.GCD.gcd_recursive;

public class LCM {
    public int lcm_1(int a, int b) {
        return a * b / gcd_recursive(a, b);
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

//    public int lcm_4(int a, int b) {
//        Set<Integer> pf1 = ,pf2 =;
//        pf1.retainAll(pf2);
//    }

//    private Set<Integer> getPrimeFactors() {
//
//    }
}
