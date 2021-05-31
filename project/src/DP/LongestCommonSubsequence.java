package DP;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println("LCS: " + lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
        System.out.println("LCS: " + lcsBottomUp(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
    }

    private static int lcsBottomUp(char[] x, char[] y, int m, int n) {
        int t[][] = new int[m + 1][n + 1];
        for (int i  = 0; i <=m ; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[m][n];
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else if (x[m - 1] == y[n - 1]) {
            return 1 + lcs(x, y, m - 1, n - 1);
        } else
            return Integer.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
    }
}
