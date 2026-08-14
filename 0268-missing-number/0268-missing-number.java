class Solution {
    public int missingNumber(int[] arr) {
        
        int ans = arr.length;
        for(int i=0; i<arr.length; i++){

            ans ^= i ^ arr[i]; 
        }
        return ans;
    }
}