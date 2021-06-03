package roundOne;

import java.util.ArrayList;
import java.util.List;

public class MinimumCoins {
    public static void main(String[] args) {
        int coins[] = new int[]{25, 10, 5};
        int sum = 30;
        System.out.println("Minimum coins required: " + minimumCoins(coins, coins.length, sum));
        printMinimumCoins(coins, coins.length, sum, new ArrayList<>());
    }

    private static int minimumCoins(int[] coins, int n, int sum) {
        if (n == 0 && sum != 0)
            return Integer.MAX_VALUE - 1;
        else if (sum == 0)
            return 0;
        else if (coins[n - 1] <= sum) {
            return Integer.min(1 + minimumCoins(coins, n, sum - coins[n - 1]), minimumCoins(coins, n - 1, sum));
        }
        else
            return minimumCoins(coins, n - 1, sum);
    }

    private static void printMinimumCoins(int[] coins, int n, int sum, List<Integer> res) {
        if (n == 0 && sum != 0)
            return;
        else if (sum < 0)
            return;
        else if (sum == 0) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        printMinimumCoins(coins, n - 1, sum, res);
        List<Integer> res1 = new ArrayList<>();
        res1.add(coins[n - 1]);
        printMinimumCoins(coins, n, sum - coins[n - 1], res1);

    }
}
