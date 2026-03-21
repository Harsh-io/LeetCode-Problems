//APPROACH 
//i = top corner , j = bottom 
//while (top < bottom){swap rows}
class Solution {
    public int[][] reverseSubmatrix(int[][] arr, int x, int y, int k) {
        
        int i = x;
        int j = x + k - 1;

        while(i < j){
            for(int col = y; col < y + k; col++){
                int temp = arr[i][col];
                arr[i][col] = arr[j][col];
                arr[j][col] = temp;
            }
            i++;  
            j--;  
        }

        return arr;
    }
}
