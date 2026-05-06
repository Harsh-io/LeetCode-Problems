class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length + 1];
        int[] ans = new int[2];

        for(int num : nums){
            freq[num]++;
        }

        for(int i = 1; i <= nums.length; i++){
            if(freq[i] == 2) ans[0] = i;
            if(freq[i] == 0) ans[1] = i;
        }

        return ans;
    }
}