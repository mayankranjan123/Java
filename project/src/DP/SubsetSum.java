package DP;

import java.util.Vector;

public class SubsetSum {
    public static void main(String[] args) {
        int arr [] = new int[]{2, 3, 5};
        int sum = 5;

        System.out.println("Subset Sum: " + isSubsetSum(arr, arr.length, sum));
        System.out.println("Subset Sum: " + isSubsetSumBottomUp(arr, arr.length, sum));
        printSubsetSum(arr, arr.length, new Vector<>(), sum);
    }

    public static boolean isSubsetSumBottomUp(int[] arr, int n, int sum) {
        boolean t[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum ; j++) {
                if (i == 0) {
                    t[i][j] = false;
                } else if (j == 0) {
                    t[i][j] = true;
                } else if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                  t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    private static boolean isSubsetSum(int[] arr, int n, int sum) {
        if (n == 0)
            return false;
        else if (sum == 0)
            return true;
        else if (arr[n - 1] <= sum)
            return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
        else
        return isSubsetSum(arr, n - 1, sum);
    }

    private static void printSubsetSum(int[] arr, int n, Vector<Integer> list, int sum) {
        if (sum == 0) {
            for (int i = 0 ;i < list.size(); i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
            return;
        }
        if (n == 0)
            return;

        printSubsetSum(arr, n - 1, list, sum);
        Vector<Integer> list1 = new Vector<>(list);
        list1.add(arr[n - 1]);
        printSubsetSum(arr, n - 1, list1, sum - arr[n - 1]);
    }

}
