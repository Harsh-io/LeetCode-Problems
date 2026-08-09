class Solution {

    class Pair{
        int row;
        int col;

        Pair(int _row, int _col){
            this.row = _row;
            this.col = _col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        int original = image[sr][sc];

        // No work needed
        if (original == color) {
            return image;
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new Pair(sr, sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, -1, 0, +1};

        while(!q.isEmpty()){

            Pair p = q.poll();

            int r = p.row;
            int c = p.col;
            
            for(int i=0; i<4; i++){

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >=0 && nrow < m && 
                ncol >= 0 && ncol < n && 
                !vis[nrow][ncol] && image[nrow][ncol] == original){

                    vis[nrow][ncol] = true;
                    image[nrow][ncol] = color;

                    q.add(new Pair(nrow, ncol));

                }
            }
        }
        
        return image;
    }
}