class Solution {

    class Pair{
        int row;
        int col;
        int maxt;

        Pair(int _row, int _col, int _maxt){
            this.row = _row;
            this.col = _col;
            this.maxt = _maxt;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int cntFresh = 0;

        Queue<Pair> q = new ArrayDeque<>();
        int[][] vis = new int [m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j , 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1)cntFresh++;
            }
        }

        int maxt = 0;
        int cnt = 0;
        int[] drow = {-1, 0 , +1, 0};
        int[] dcol = {0, -1, 0, +1};

        while(!q.isEmpty()){

            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().maxt;

            maxt = Math.max(maxt, t);
            q.remove();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){

                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh) return -1;
        return maxt;
    }
}