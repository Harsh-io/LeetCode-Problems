//find all substring from i=0->n  if found return true and change pointer to idx+1 next element as head;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int[] dp = new int[301]; //s.length()
        Arrays.fill(dp, -1);
        HashSet<String> set = new HashSet<>(wordDict); //to access in O(1) time

        return solve(0, s, set, dp);
    }

    public boolean solve(int i, String s, HashSet<String> set, int[] dp) {

        if (i == s.length()) {
            return true;
        }

        if(dp[i] != -1) return dp[i] == 1;

        for (int j = i; j < s.length(); j++) {

            String word = s.substring(i, j + 1);

            if (set.contains(word)) {
                if (solve(j + 1, s, set, dp)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] =  0;
        return false;
    }
}