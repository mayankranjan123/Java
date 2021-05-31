package DP;

public class CountSubsetSum {
    public static void main(String[] args) {
        int arr [] = new int[]{0,0,0,0,0,0,0,0,1};
        int sum = 1;

        System.out.println("Subset Sum: " + countSubsetSum(arr, arr.length, sum));
        System.out.println("Subset Sum: " + countSubsetSumBottomUp(arr, arr.length, sum));
    }

    private static int countSubsetSumBottomUp(int[] arr, int n, int sum) {
        int t[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j  = 0; j <= sum; j++) {
                if (i == 0 && j != 0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                } else if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    private static int countSubsetSum(int[] arr, int n, int sum) {
        if (n == 0 && sum != 0)
            return 0;
        else if (sum == 0)
            return 1;
        else if (arr[n - 1] <= sum)
            return countSubsetSum(arr, n - 1, sum - arr[n - 1]) + countSubsetSum(arr, n - 1, sum);
        else
            return countSubsetSum(arr, n - 1, sum);
    }
}
