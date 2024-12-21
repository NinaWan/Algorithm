package math.calculation.quickPower;

public class QuickPower {
    public long iteration(long base, long exponent, int mod) {
        long res = 1;
        base %= mod;
        for (; exponent > 0; exponent >>= 1) {
            if ((exponent & 1) == 1) { // is odd
                res = res * base % mod;
            }
            base = base * base % mod;
        }
        return res % mod;
    }

    public long recursion(long base, long exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }

        base %= mod;
        long res = recursion(base, exponent / 2, mod);
        return exponent % 2 == 0 ? res * res % mod : res * res * base % mod;
    }
}
