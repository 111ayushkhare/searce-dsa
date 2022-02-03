package week4day4.practice.q3;

class SubsetSum {
    private static boolean[][] memo;

    boolean isSubsetSum(int[] arr, int sum, int n, int ch) {
        if (ch == 0) {
            return isSubsetSumRecur(arr, sum, n);
        } else {
            memo = new boolean[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    memo[i][j] = false;
                }
            }
            return isSubsetSumMemoization(arr, sum, n);
        }
    }

    // Regular recursive method  to find is subset with given sum present
    private boolean isSubsetSumRecur(int[] arr, int sum, int n) {
        if (n == 0) { return false; }
        if (sum == 0) { return true; }

        if (arr[n - 1] <= sum) {
            return isSubsetSumRecur(arr, sum - arr[n - 1], n - 1) || isSubsetSumRecur(arr, sum, n - 1);
        } else {
            return isSubsetSumRecur(arr, sum, n - 1);
        }
    }

    // DP method - memoization to find is subset with given sum present
    private boolean isSubsetSumMemoization(int[] arr, int sum, int n) {
        if (sum == 0) { return true; }
        if (n == 0) { return false; }
        if (memo[n][sum]) { return memo[n][sum]; }

        if (arr[n - 1] <= sum) {
            memo[n][sum] = isSubsetSumRecur(arr, sum - arr[n - 1], n - 1) || isSubsetSumRecur(arr, sum, n - 1);
        } else {
            memo[n][sum] = isSubsetSumRecur(arr, sum, n - 1);
        }

        return memo[n][sum];
    }
}
