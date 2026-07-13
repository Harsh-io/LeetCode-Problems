class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];

        return solve(0, board, n);
    }

    public int solve(int col, int[][] board, int n){

        if(col == n) return 1;

        int ans = 0;
        
        for(int row=0; row<n; row++){
            if(isSafe(row, col, board, n)){

                board[row][col] = 1;
                ans += solve(col+1, board, n);
                board[row][col] = 0;
            }
        }
        return ans;
    } 

    public boolean isSafe(int i, int j, int[][]board, int n){

        for(int col = j; col >= 0; col--){
            if(board[i][col] == 1) return false;
        }

        for(int row = i, col = j; row>=0 && col >=0; row--, col--){
            if(board[row][col] == 1) return false;
        }

        for(int row = i, col = j; row < n && col >=0; row++, col--){
            if(board[row][col] == 1) return false;
        }

        return true;
    }
}