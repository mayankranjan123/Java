package DP;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {
    public static void main(String[] args) {
        int val[] = { 40, 100, 50, 60};
        int wt[] = { 20, 10, 40, 30};
        int W = 60;
        int n = val.length;
        System.out.println(knapSack(wt, val, W, n));
        System.out.println(knapSackBottomUp(wt, val, W, n));
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        map.put("name", "mayank");
        map.put("age", "22");
        String json = gson.toJson(map);
        System.out.println(json);
        Map map1 =  gson.fromJson(json, Map.class);
        System.out.println(map1.get("name"));
    }

    public int get(int a) {
        System.out.println("Working");
        return a*a;
    }

    private static int knapSackBottomUp(int[] wt, int[] val, int w, int n) {
        int t[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Integer.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        int res = t[n][w];
        int j = w;
        System.out.println("Maximum Profit: " + res);

        for (int i = n; i > 0 && res > 0; i--) {
            if (res == t[i - 1][j])
                continue;
            else {
                System.out.print(wt[i - 1] + " ");
                res = res - val[i - 1];
                j = j - wt[i - 1];
            }
        }
        return 0;
    }

    private static int knapSack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;
        else if (wt[n - 1] <= W)
            return Integer.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
        else
            return knapSack(wt, val, W, n - 1);
    }


}
