class Solution {
    static int n;
    static int m;
    public static int numIslands(char[][] grid) {
        
        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == '1' && vis[i][j] == false){
                    ans++;
                    dfs(i, j, vis, grid);

                }

                vis[i][j] = true;
            }
        }

        return ans;
    }

    public static void dfs(int i, int j, boolean[][] vis, char[][] grid){
        
        vis[i][j] = true;

        if(i+1 < n && grid[i+1][j] == '1' && !vis[i+1][j]){
            dfs(i+1, j, vis, grid);
        }
        if(j+1 < m && grid[i][j+1] == '1' && !vis[i][j+1]){
            dfs(i, j+1, vis, grid);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1'  && !vis[i][j-1]){
            dfs(i, j-1, vis, grid);
        }
        if(i-1 >=0 && grid[i-1][j] == '1' && !vis[i-1][j]){
            dfs(i-1, j, vis, grid);
        }
    }
}