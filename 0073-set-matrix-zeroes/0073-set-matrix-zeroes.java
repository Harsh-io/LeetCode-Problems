class Solution {
    public void setZeroes(int[][] mat) {
        
        boolean[] rows = new boolean[mat.length];
        boolean[] cols = new boolean[mat[0].length];

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){

                if(mat[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){

                if(rows[i] || cols[j]){
                    mat[i][j] = 0;
                }
            }
        }
    }
}