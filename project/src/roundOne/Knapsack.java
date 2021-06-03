package roundOne;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    static List<List<Integer>> knapsacks = new ArrayList<>();
    public static void main(String[] args) {
        int val[] = new int[]{10, 15, 40};
        int wt[] = new int[]{1, 2, 3};
        System.out.println("Max Value: " + knapsack(wt, val, wt.length, 6));
        knapsackPrint(wt, val, wt.length, 6, new ArrayList<>());
        System.out.println("Final Knapsack: " + knapsacks.get(knapsacks.size() - 1));
    }

    private static int knapsack(int[] wt, int[] val, int n, int W) {
        if (n == 0 || W == 0)
            return 0;
        else if (wt[n - 1] <= W) {
            return Integer.max(val[n -1]  + knapsack(wt, val, n - 1, W - wt[n - 1]), knapsack(wt, val, n - 1, W));
        }
        return knapsack(wt, val, n - 1, W);
    }

    private static void knapsackPrint(int[] wt, int[] val, int n, int W, List<Integer> res) {
        if (n == 0 || W == 0) {
            knapsacks.add(res);
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        knapsackPrint(wt, val, n - 1, W, res);
        List<Integer> res1 = new ArrayList<>(res);
        res1.add(val[n - 1]);
        knapsackPrint(wt, val, n - 1, W - wt[n - 1], res1);


    }
}
