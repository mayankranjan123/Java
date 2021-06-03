package DP;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "banana";
        System.out.println("Longest repeating subsequence: " + lcs(s, s));
    }

    private static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int t[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }
}
