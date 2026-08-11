class Solution {

    int[] dp;
    public boolean winnerSquareGame(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n); //call for alice
    }

    private boolean solve(int n) {

        if (n == 0) {
            return false; //whosever turn this was looses the game
        }

        if (dp[n] != -1) return dp[n] == 1;

        for (int k = 1; k * k <= n; k++) {

            // If opponent loses after our move, current player wins.
            if (solve(n - k * k) == false) {  //call for bob at first -> alice -> bob..
                dp[n] = 1;
                return true; //alice wins
            }
        }

        dp[n] = 0;
        return false; //alice can never win
    }
}

//TC: O(N * Sqrt(n));
//SC: O(N)