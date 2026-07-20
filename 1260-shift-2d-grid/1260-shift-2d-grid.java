class Solution {
    public List<List<Integer>> shiftGrid(int[][] arr, int k) {

        int r = arr.length;
        int c = arr[0].length;

        if(k >= r*c) k = k % (r * c);

        for(int i=0; i<k; i++){

            int prev = arr[r-1][c-1];

            for(int row = r-1; row >= 0; row--){

                for(int col = c-1; col >= 1; col--){
                    arr[row][col] = arr[row][col - 1];
                }

                if(row > 0){
                    arr[row][0] = arr[row - 1][c - 1];
                }
            }
            arr[0][0] = prev;
        }

        List<List<Integer>> ans = new ArrayList<>();

         for(int i = 0; i < r; i++){
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < c; j++){
                list.add(arr[i][j]);
            }

            ans.add(list);
        }

        return ans;
    }
}