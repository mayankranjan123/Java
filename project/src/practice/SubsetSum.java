package practice;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int a[] = new int[] {2, 5, 3, 1, 6, 8};
        int sum = 8;
        System.out.println("Subset Sum: " + subsetSum(a, a.length, sum));
        List<Integer> res = new ArrayList<>();
        printSubsetSum(a, a.length, sum, res);
        System.out.println(list);
    }

    private static void printSubsetSum(int[] a, int n, int sum, List<Integer> res) {
        if (n == 0 && sum != 0)
            return;
        else if (sum == 0) {
            for (Integer i : res) {
                list.add(res);
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            printSubsetSum(a, n - 1, sum, res);
            List<Integer> res1 = new ArrayList<>(res);
            res1.add(a[n - 1]);
            printSubsetSum(a, n - 1, sum - a[n - 1], res1);
        }

    }

    private static boolean subsetSum(int[] a, int n, int sum) {
        if (n == 0 && sum != 0)
            return false;
        else if (sum == 0)
            return true;
        else if (a[n - 1] <= sum)
            return subsetSum(a, n - 1, sum - a[n -1]) || subsetSum(a, n - 1, sum);
        else
            return subsetSum(a, n - 1, sum);
    }
}
