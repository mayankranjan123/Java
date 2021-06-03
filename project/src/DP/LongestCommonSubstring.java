package DP;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "maya";
        String y = "Amayank";
        System.out.println("LCS: " + lcs(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
        System.out.println("LCS: " + lcsBottomUp(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
    }

    private static int lcsBottomUp(char[] x, char[] y, int m, int n) {
        int result = Integer.MIN_VALUE;
        int t[][] = new int[m + 1][n + 1];
        for (int i  = 0; i <=m ; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    result = Integer.max(t[i][j], result);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return result;
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else if (x[m - 1] == y[n - 1]) {
            return 1 + lcs(x, y, m - 1, n - 1);
        } else
            return 0;
    }
}
