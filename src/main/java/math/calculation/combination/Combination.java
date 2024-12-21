package math.calculation.combination;

public class Combination {
    // C(n, m) = n!/(m!*(n-m)!)
    public long combination_formula_1(long n, long m) {
        long res = 1;
        for (long i = n - m + 1; i <= n; i++) {
            res *= i;
        }
        for (long i = 1; i <= m; i++) {
            res /= i;
        }
        return res;
    }

    // C(n, m) = n!/(m!*(n-m)!)
    public long combination_formula_2(int n, int m) {
        long res = 1, k = 1;
        while (k <= m) {
            res = (n - k + 1) * res / k;
            k++;
        }
        return res;
    }

    public int combination_recursive(int n, int m, int[][] memo, int mod) {
        if (m == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (memo[n][m] != 0) {
            return memo[n][m];
        }

        return memo[n][m] = (combination_recursive(n - 1, m, memo, mod) + combination_recursive(n - 1, m - 1, memo, mod)) % mod;
    }

    public long combination_pascal_triangle(int n, int m, long mod) {
        long[][] triangle = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]) % mod;
            }
        }
        return triangle[n][m];
    }

    public long combination_inverse(int n, int m) {
        int mod = (int) 1e9 + 7;
        // pre-calculations
        long[] fact = new long[n + 1]; // fact[i] - i!, factorial of i
        long[] inv = new long[n + 1]; // inv[i] - multiplicative inverse modulo for factorial of i
        fact[0] = inv[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % mod;
            inv[i] = quickPowMod(fact[i], mod - 2, mod); // inv[i] = (1/i!)%mod
        }

        // C(n, m) = n!/(m!*(n-m)!) = n! * 1/m! * 1/(n-m)!
        return fact[n] * inv[m] % mod * inv[n - m] % mod;
    }

    private long quickPowMod(long base, int exponent, int mod) {
        long res = 1;

        for (; exponent > 0; exponent >>= 1) {
            if ((exponent & 1) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
        }

        return res;
    }
}
