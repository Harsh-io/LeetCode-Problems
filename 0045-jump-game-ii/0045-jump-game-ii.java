class Solution {
    int[] dp;

    public int jump(int[] arr) {

        dp = new int[arr.length];
        return solve(arr, 0);
    }

    public int solve(int[] arr, int idx) {

        if (idx >= arr.length - 1) {
            return 0;
        }

        if (arr[idx] == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int minIdx = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[idx]; i++) {

            int ans = solve(arr, idx + i);

            if (ans != Integer.MAX_VALUE) {
                minIdx = Math.min(minIdx, ans + 1);
            }
        }

        return dp[idx] = minIdx;
    }
}