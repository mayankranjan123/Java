package DP;

public class MinimumCoins {
    public static void main(String[] args) {
        int coins[] = new int[]{9, 6, 5, 1};
        int sum = 11;
        System.out.println("Minimum coins required: " + minimumCoins(coins, coins.length, sum));
    }

    private static int minimumCoinsRecursion(int[] coins, int n, int sum) {
        if (n == 0 && sum != 0)
            return Integer.MAX_VALUE - 1;
        else if (sum == 0)
            return 0;
        else if (coins[n - 1] <= sum)
            return Integer.min(1 + minimumCoinsRecursion(coins, n, sum - coins[n - 1]), minimumCoinsRecursion(coins, n - 1, sum));
        else
            return minimumCoinsRecursion(coins, n - 1, sum);

    }

    private static int minimumCoins(int[] coins, int n, int sum) {
        int t[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j != 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                } else if (j == 0) {
                    t[i][j] = 0;
                } else if (coins[i - 1] <= j) {
                    t[i][j] = Integer.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i- 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
