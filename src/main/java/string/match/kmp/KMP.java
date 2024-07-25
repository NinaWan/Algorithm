package string.match.kmp;

public class KMP {
    public int match(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return -1;
        }

        if (pattern.isEmpty() || pattern.equals(text)) {
            return 0;
        }

        int[] pmt = generatePartialMatchTable(pattern);
        for (int i = 0, j = 0; j < text.length(); j++) {
            while (i > 0 && pattern.charAt(i) != text.charAt(j)) {
                i = pmt[i - 1];
            }

            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
            }

            if (i == pattern.length()) {
                return j + 1 - pattern.length();
            }
        }

        return -1;
    }

    private int[] generatePartialMatchTable(String s) {
        int[] res = new int[s.length()];

        for (int i = 1, l = 0; i < res.length; ) {
            if (s.charAt(i) == s.charAt(l)) {
                res[i++] = ++l;
            } else if (l > 0) {
                l = res[l - 1];
            } else {
                i++;
            }
        }

        return res;
    }
}
