class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] arr) {
     
    int n = arr.length;
    dp = new Integer[n][n];

    return solve(arr, 0, n-1) > 0;
    }

    public int solve(int[] arr, int i, int j){

         // only one pile left
        if(i == j){
            return arr[i];
        }

        if(dp[i][j] != null) return dp[i][j];

        //take left 
        int left = arr[i] - solve(arr, i+1, j);

        //take right
        int right = arr[j] - solve(arr, i, j-1);

        return dp[i][j] = Math.max(left, right);


    }
}
