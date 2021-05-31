package DP;

public class MaxWaysCoinChange {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3};
        int sum = 5;
        System.out.println("Max Ways to get Sum using coins: " + maxWaysCoinChange(arr, arr.length, sum));
    }

    private static int maxWaysCoinChange(int[] arr, int n, int sum) {
        int t[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j!=0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                } else if (arr[i - 1] <= j) {
                    t[i][j] = t[i][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
