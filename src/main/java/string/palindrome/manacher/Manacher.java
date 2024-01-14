package string.palindrome.manacher;

public class Manacher {
    /**
     * @param s Original string
     * @return The longest palindromic substring of s
     */
    public String longestPalindromicSubstring(String s) {
        StringBuilder t = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            t.append(c).append("#");
        }

        int[] p = manacher_odd(t.toString());
        int index = 0, maxLen = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > maxLen + 1) {
                maxLen = p[i] - 1;
                index = i;
            }
        }

        int beginIndex = (index - p[index] + 1) / 2;
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public int[] manacher_odd(String s) { // len[i] = 2*p[i]-1
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0, l = 0, r = 0; i < n; i++) {
            p[i] = i >= r ? 1 : Math.min(p[l + r - i], r - i + 1);

            while (i - p[i] >= 0 && i + p[i] < n && s.charAt(i - p[i]) == s.charAt(i + p[i])) {
                p[i]++;
            }

            if (i + p[i] - 1 > r) {
                l = i - (p[i] - 1);
                r = i + (p[i] - 1);
            }
        }
        return p;
    }

    public int[] manacher_even(String s) { // len[i] = 2*p[i]
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0, l = 0, r = 0; i < n; i++) {
            p[i] = i >= r ? 0 : Math.min(p[l + r - i + 1], r - i + 1);

            while (i - p[i] - 1 >= 0 && i + p[i] < n && s.charAt(i - p[i] - 1) == s.charAt(i + p[i])) {
                p[i]++;
            }

            if (i + p[i] - 1 > r) {
                l = i - (p[i] - 1) - 1;
                r = i + (p[i] - 1);
            }
        }
        return p;
    }
}
