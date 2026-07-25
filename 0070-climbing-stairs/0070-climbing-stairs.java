class Solution {

    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return solve(0, n, dp);
    }

    public int solve(int sum, int n, Integer[] dp) {

        if (sum == n) return 1;

        if (sum > n) return 0;

        if (dp[sum] != null) return dp[sum];

        int ways = 0;

        for (int i = 1; i <= 2; i++) {
            ways += solve(sum + i, n, dp);
        }

        dp[sum] = ways;
        return dp[sum];
    }
}