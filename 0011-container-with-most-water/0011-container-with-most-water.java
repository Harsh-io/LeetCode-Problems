class Solution {
    public int maxArea(int[] arr) {
        
        int i = 0;
        int j = arr.length-1;
        int max = 0;

        while(i < j){

            max = Math.max(max, (j-i) * Math.min(arr[i], arr[j]));
           
            if(arr[i] < arr[j]) i++;
            else j--;

        }

        return max;
    }
}