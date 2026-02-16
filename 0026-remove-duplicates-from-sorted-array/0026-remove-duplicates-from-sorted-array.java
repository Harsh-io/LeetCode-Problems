class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0; i<n-1; i++){
            if(nums[i] != nums[i+1]){
                cnt++;
                nums[cnt] = nums[i+1];
            }
        }
        return cnt+1;
    }
}