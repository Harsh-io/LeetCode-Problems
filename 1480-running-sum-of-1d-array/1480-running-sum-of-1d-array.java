class Solution {
    public int[] runningSum(int[] nums) {
        int i;
        int sum=0;
        int n= nums.length;

        for ( i = 1; i < n; i++) {
            
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;

        
    }
}