class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        
        int l = 0;
        int sum = 0;
        int min  = Integer.MAX_VALUE;

        for(int r = 0; r<arr.length; r++){

            sum += arr[r];

            while(sum >= target){
                
                min = Math.min(min, r-l+1);
                sum -= arr[l];
                l++;
            }
        }
        if(min == Integer.MAX_VALUE) return  0;
        return min;
    }
}