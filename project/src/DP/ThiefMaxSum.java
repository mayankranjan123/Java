package DP;

public class ThiefMaxSum {
    public static void main(String[] args) {
        int a[] = new int[]{2,7,9,3,1};
        System.out.println("Max Sum: " + rob(a));
    }

    public static int rob(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        else if (a.length == 1)
            return a[0];
        else if (a.length == 2)
            return Math.max(a[0], a[1]);
        else {
            int dp[] = new int[a.length];
            dp[0] = a[0];
            dp[1] = Math.max(a[0], a[1]);

            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(a[i] + dp[i - 2], dp[i - 1]);
            }

            return dp[a.length - 1];
        }

    }
}