class Solution {
    public int[] runningSum(int[] arr) {
        
        int[] ans = new int[arr.length];
        ans[0] = arr[0];

        for(int i=1; i<arr.length; i++){

            int j=i;

            while(j >= 0){
                ans[i] += arr[j];
                j--;
            }
            
        }

        return ans;
    }
}