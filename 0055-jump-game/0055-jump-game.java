class Solution {
    public boolean canJump(int[] arr) {
        
        int max = 0;

        for(int i=0; i<arr.length; i++){

            if(i > max) return false;
            max = Math.max(arr[i] + i , max);
        }

        return max >= arr.length-1;
    }
}