class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        
        if (k <= 1) return 0;

        int cnt  = 0;
        int left = 0;
        int prod = 1;

        for(int right=0; right<arr.length; right++){
            
            prod *= arr[right];

            while(prod >= k){
                prod = prod/arr[left];
                left++;
            }
            // Number of valid subarrays = window size | [10,5,2,6] = [10], [5], [2]
            cnt += right - left + 1;
        } 
        return cnt;  
    }
}