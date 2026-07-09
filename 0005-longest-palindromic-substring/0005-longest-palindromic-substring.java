import java.util.*;

class Solution {

    int[][] dp = new int[1001][1001];

    int solve(String s, int i, int j) {
        if (i >= j) return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1);
        }

        return dp[i][j] = 0;
    }

    public String longestPalindrome(String s) {
        int n = s.length();

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxLen = 0;
        int sp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (solve(s, i, j) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }
}