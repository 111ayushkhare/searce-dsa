package week4day4.practice.q2;

class Knapsack01 {
    private static int[][] memo;

    int knapsack01(int[] wt, int[] val, int W, int n, int ch) {
        if (ch == 0) {
            return knapsack01Recur(wt, val, W, n);
        } else {
            memo = new int[n + 1][W + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= W; j++) {
                    memo[i][j] = -1;
                }
            }
            return knapsack01Memoization(wt, val, W, n);
        }
    }

    // Regular recursive method to solve the problem
    private int knapsack01Recur(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack01Recur(wt, val, W - wt[n - 1], n - 1), knapsack01Recur(wt, val, W, n - 1));
        } else {
            return knapsack01Recur(wt, val, W, n - 1);
        }
    }

    // DP technique - Memoization
    private int knapsack01Memoization(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) { return 0; }
        if (memo[n][W] != -1) { return memo[n][W]; }

        if (wt[n - 1] <= W) {
            memo[n][W] = Math.max(val[n - 1] + knapsack01Recur(wt, val, W - wt[n - 1], n - 1), knapsack01Recur(wt, val, W, n - 1));
        } else {
            memo[n][W] = knapsack01Recur(wt, val, W, n - 1);
        }

        return memo[n][W];
    }
}