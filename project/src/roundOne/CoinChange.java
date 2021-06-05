package roundOne;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        int n = arr.length;
        int sum = 4;
        System.out.println(coinChange(arr, n, sum));
        printCoinChange(arr, n, sum, new ArrayList<>());
    }

    private static int coinChange(int[] arr, int n, int sum) {
        if (n == 0 && sum!= 0)
            return 0;
        else if (sum == 0)
            return 1;
        else if (arr[n - 1] <= sum) {
            return coinChange(arr, n, sum - arr[n - 1]) + coinChange(arr, n - 1, sum);
        }
        else
            return coinChange(arr, n - 1, sum);
    }

    private static void printCoinChange(int[] arr, int n, int sum, List<Integer> res) {
        if (n == 0 && sum!= 0)
            return;
        else if (sum < 0) {
            return;
        }
        else if (sum == 0) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        printCoinChange(arr, n - 1, sum, res);
        List<Integer> res1 = new ArrayList<>(res);
        res1.add(arr[n - 1]);
        printCoinChange(arr, n, sum - arr[n - 1], res1);
    }
}
