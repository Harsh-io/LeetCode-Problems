class Solution {
    public int pivotIndex(int[] arr) {
        
        int n = arr.length;
        int[] prefixsum = new int[n];
        int[] suffixsum = new int[n];

        prefixsum[0] = 0;
        for(int i=1; i<n; i++){
            prefixsum[i] =  prefixsum[i-1] + arr[i-1]; 
        }

        suffixsum[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            suffixsum[i] =  suffixsum[i+1] + arr[i+1]; 
        }

        for(int i=0; i<n; i++){
            if((prefixsum[i]-suffixsum[i])==0) return i;     
        }

        return -1;
    }
}