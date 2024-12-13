package math.gcd;

public class GCD {
    public static int gcd_recursive(int a, int b) {
        return b == 0 ? a : gcd_recursive(b, a % b);
    }

    public int gcd_iterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}